package com.syamsundar.moviebooking.theatre.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateTheatreRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotNull
    private UUID cityId;
}
