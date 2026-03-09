package com.syamsundar.moviebooking.city;

import com.syamsundar.moviebooking.city.dto.CityResponse;
import com.syamsundar.moviebooking.city.dto.CreateCityRequest;
import com.syamsundar.moviebooking.theatre.TheatreRepository;
import com.syamsundar.moviebooking.theatre.TheatreService;
import com.syamsundar.moviebooking.theatre.dto.TheatreResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;
    private final TheatreService theatreService;

    @PostMapping
    public CityResponse createCity(@Valid @RequestBody CreateCityRequest request){
        return cityService.createCity(request);
    }

    @GetMapping("/{cityId}/theatres")
    public List<TheatreResponse> getTheatresByCity(@PathVariable UUID cityId){
        return theatreService.getTheatresByCity(cityId);
    }
}
