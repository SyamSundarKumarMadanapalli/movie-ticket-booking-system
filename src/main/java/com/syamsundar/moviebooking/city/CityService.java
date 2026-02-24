package com.syamsundar.moviebooking.city;

import com.syamsundar.moviebooking.city.dto.CityResponse;
import com.syamsundar.moviebooking.city.dto.CreateCityRequest;
import com.syamsundar.moviebooking.common.exception.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public CityResponse createCity(CreateCityRequest request){
        cityRepository.findByName(request.getName())
                .ifPresent(city -> {
                        throw new ConflictException("City already exists");
        });

        City city = new City();
        city.setName(request.getName());

        City saved = cityRepository.save(city);

        return CityResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .build();
    }
}
