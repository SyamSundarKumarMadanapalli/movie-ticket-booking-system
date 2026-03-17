package com.syamsundar.moviebooking.screen.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateScreenRequest {

    @NotBlank
    private String name;

    @NotNull
    private Integer totalSeats;

    @NotNull
    private UUID theatreId;
}
