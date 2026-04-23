package com.syamsundar.moviebooking.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class LockSeatsRequest {

    private UUID showId;
    private List<UUID> seatIds;
}
