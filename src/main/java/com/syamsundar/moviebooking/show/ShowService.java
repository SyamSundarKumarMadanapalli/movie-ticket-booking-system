package com.syamsundar.moviebooking.show;

import com.syamsundar.moviebooking.common.exception.ConflictException;
import com.syamsundar.moviebooking.common.exception.ResourceNotFoundException;
import com.syamsundar.moviebooking.config.BookingProperties;
import com.syamsundar.moviebooking.movie.Movie;
import com.syamsundar.moviebooking.movie.MovieRepository;
import com.syamsundar.moviebooking.screen.Screen;
import com.syamsundar.moviebooking.screen.ScreenRepository;
import com.syamsundar.moviebooking.show.dto.CreateShowRequest;
import com.syamsundar.moviebooking.show.dto.ShowResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;
    private final BookingProperties bookingProperties;

    public ShowResponse createShow(CreateShowRequest request){
        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        Screen screen = screenRepository.findById(request.getScreenId())
                .orElseThrow(() -> new ResourceNotFoundException("Screen not found"));

        //to find the show which intersects with the timings of any other show
//        List<Show> overlaps = showRepository.findOverlappingShows(
//                screen.getId(),
//                request.getStartTime(),
//                request.getEndTime()
//        );
//
//        if(!overlaps.isEmpty()){
//            throw new ConflictException("Show timings overlap with the existing show");
//        }

        int buffer = bookingProperties.getBufferTimeMinutes();
        System.out.println(buffer + "............................");
        List<Show> existingShows = showRepository.findByScreen_Id(screen.getId());

        for(Show existing : existingShows){
            LocalDateTime bufferedEnd = existing.getEndTime().plusMinutes(buffer);
            System.out.println(bufferedEnd + "..........................");

            if(request.getStartTime().isBefore(bufferedEnd) && request.getEndTime().isAfter(existing.getStartTime())){
                throw new ConflictException("Show overlaps or violates buffer time");
            }
        }

        Show show = new Show();
        show.setMovie(movie);
        show.setScreen(screen);
        show.setStartTime(request.getStartTime());
        show.setEndTime(request.getEndTime());

        Show saved = showRepository.save(show);

        return ShowResponse.builder()
                .id(saved.getId())
                .movieId(movie.getId())
                .screenId(screen.getId())
                .startTime(saved.getStartTime())
                .endTime(saved.getEndTime())
                .build();
    }
}
