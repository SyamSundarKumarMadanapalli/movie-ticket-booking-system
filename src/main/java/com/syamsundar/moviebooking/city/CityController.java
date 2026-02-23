package com.syamsundar.moviebooking.city;

import com.syamsundar.moviebooking.city.dto.CityResponse;
import com.syamsundar.moviebooking.city.dto.CreateCityRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public CityResponse createCity(@Valid @RequestBody CreateCityRequest request){
        return cityService.createCity(request);
    }
}
