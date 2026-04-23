package com.syamsundar.moviebooking.booking;

import com.syamsundar.moviebooking.booking.dto.LockSeatsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class SeatLockController {

    private final SeatLockService seatLockService;

    @PostMapping("/lock-seats")
    public ResponseEntity<String> lockSeats(@RequestBody LockSeatsRequest request){
        seatLockService.lockSeats(request.getShowId(), request.getSeatIds());

        return ResponseEntity.ok("Seats locked successfully");
    }
}
