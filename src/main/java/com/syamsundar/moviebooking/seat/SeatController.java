package com.syamsundar.moviebooking.seat;

import com.syamsundar.moviebooking.seat.dto.CreateSeatLayoutRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @PostMapping("/layout")
    public String createSeatLayout(@Valid @RequestBody CreateSeatLayoutRequest request){
        seatService.createSeatLayout(request);
        return "Seat Layout created Successfully";
    }
}
