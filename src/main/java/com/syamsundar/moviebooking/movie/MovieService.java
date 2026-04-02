package com.syamsundar.moviebooking.movie;

import com.syamsundar.moviebooking.common.exception.ConflictException;
import com.syamsundar.moviebooking.movie.dto.CreateMovieRequest;
import com.syamsundar.moviebooking.movie.dto.MovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieResponse createMovie(CreateMovieRequest request){

        movieRepository.findByTitle(request.getTitle())
                .ifPresent(movie -> {
                    throw new ConflictException("Movie already exists");
                });

        System.out.println("Title: " + request.getTitle());
        System.out.println("Duration: " + request.getDurationInMinutes());
        System.out.println("Language: " + request.getLanguage());

        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setLanguage(request.getLanguage());
        movie.setDurationInMinutes(request.getDurationInMinutes());

        Movie saved = movieRepository.save(movie);

        return MovieResponse.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .durationInMinutes(saved.getDurationInMinutes())
                .language(saved.getLanguage())
                .build();
    }
}
