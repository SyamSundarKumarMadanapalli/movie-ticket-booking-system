package com.syamsundar.moviebooking.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class BookingRequest {
    private UUID showId;
    private List<UUID> showSeatIds;
}
