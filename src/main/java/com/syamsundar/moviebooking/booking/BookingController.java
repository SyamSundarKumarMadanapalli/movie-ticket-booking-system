package com.syamsundar.moviebooking.booking;

import com.syamsundar.moviebooking.booking.dto.BookingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody BookingRequest request){
        return bookingService.createBooking(
                request.getShowId(),
                request.getShowSeatIds()
        );
    }

    @PostMapping("/{id}/confirm")
    public String confirm(@PathVariable UUID id){
        bookingService.confirmBooking(id);
        return "Booking Confirmed";
    }
}
