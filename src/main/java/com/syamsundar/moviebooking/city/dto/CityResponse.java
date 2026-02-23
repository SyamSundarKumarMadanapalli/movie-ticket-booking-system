package com.syamsundar.moviebooking.city.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class CityResponse {

    private UUID id;
    private String name;
}
