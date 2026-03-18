package com.syamsundar.moviebooking.seat.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateSeatLayoutRequest {

    @NotNull
    private UUID screenId;

    @NotNull
    private Integer numberOfRows;

    @NotNull
    private Integer seatsPerRow;
}
