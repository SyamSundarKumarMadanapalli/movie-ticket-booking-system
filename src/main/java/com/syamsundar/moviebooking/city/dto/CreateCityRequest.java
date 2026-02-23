package com.syamsundar.moviebooking.city.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCityRequest {

    @NotBlank
    private String name;
}
