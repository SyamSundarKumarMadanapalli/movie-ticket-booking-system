package com.syamsundar.moviebooking.theatre;

import com.syamsundar.moviebooking.city.City;
import com.syamsundar.moviebooking.city.CityRepository;
import com.syamsundar.moviebooking.common.exception.ConflictException;
import com.syamsundar.moviebooking.common.exception.ResourceNotFoundException;
import com.syamsundar.moviebooking.theatre.dto.CreateTheatreRequest;
import com.syamsundar.moviebooking.theatre.dto.TheatreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TheatreService {

    private final TheatreRepository theatreRepository;
    private final CityRepository cityRepository;

    public TheatreResponse createTheatre(CreateTheatreRequest request){
        City city = cityRepository.findById(request.getCityId())
                .orElseThrow(() -> new ResourceNotFoundException("City not found"));

        boolean exists = theatreRepository.existsByNameAndCityId(request.getName(), request.getCityId());

        if(exists){
            throw new ConflictException("This theatre already exists in this city");
        }

        Theatre theatre = new Theatre();
        theatre.setName(request.getName());
        theatre.setAddress(request.getAddress());
        theatre.setCity(city);

        Theatre saved = theatreRepository.save(theatre);

        return TheatreResponse.builder()
                .id(saved.getId())
                .address(saved.getAddress())
                .cityId(city.getId())
                .name(saved.getName())
                .build();
    }

    public List<TheatreResponse> getTheatresByCity(UUID cityId){
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException("City not found"));

        List<Theatre> theatres = theatreRepository.findByCity_Id(city.getId());

        return theatres.stream()
                .map(theatre -> TheatreResponse.builder()
                        .id(theatre.getId())
                        .name(theatre.getName())
                        .address(theatre.getAddress())
                        .cityId(city.getId())
                        .build())
                .toList();
    }
}
