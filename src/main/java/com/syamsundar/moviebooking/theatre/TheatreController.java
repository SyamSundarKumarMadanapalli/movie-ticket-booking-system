package com.syamsundar.moviebooking.theatre;

import com.syamsundar.moviebooking.theatre.dto.CreateTheatreRequest;
import com.syamsundar.moviebooking.theatre.dto.TheatreResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/theatres")
@RequiredArgsConstructor
public class TheatreController {

    private final TheatreService theatreService;

    @PostMapping
    public TheatreResponse createTheatre(@Valid @RequestBody CreateTheatreRequest request){
        return theatreService.createTheatre(request);
    }
}
