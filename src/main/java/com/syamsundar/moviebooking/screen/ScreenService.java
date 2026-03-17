package com.syamsundar.moviebooking.screen;

import com.syamsundar.moviebooking.common.exception.ResourceNotFoundException;
import com.syamsundar.moviebooking.screen.dto.CreateScreenRequest;
import com.syamsundar.moviebooking.screen.dto.ScreenResponse;
import com.syamsundar.moviebooking.theatre.Theatre;
import com.syamsundar.moviebooking.theatre.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepository screenRepository;
    private final TheatreRepository theatreRepository;

    public ScreenResponse createScreen(CreateScreenRequest request){
        Theatre theatre = theatreRepository.findById(request.getTheatreId())
                .orElseThrow(()->new ResourceNotFoundException("Theatre Not Found"));

        Screen screen = new Screen();
        screen.setName(request.getName());
        screen.setTotalSeats(request.getTotalSeats());
        screen.setTheatre(theatre);

        Screen saved = screenRepository.save(screen);

        return ScreenResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .totalSeats(saved.getTotalSeats())
                .theatreId(theatre.getId())
                .build();
    }
}
