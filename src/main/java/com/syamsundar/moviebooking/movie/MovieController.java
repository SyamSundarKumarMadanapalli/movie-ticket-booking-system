package com.syamsundar.moviebooking.movie;

import com.syamsundar.moviebooking.movie.dto.CreateMovieRequest;
import com.syamsundar.moviebooking.movie.dto.MovieResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public MovieResponse createMovie(@Valid @RequestBody CreateMovieRequest request){
        return movieService.createMovie(request);
    }
}
