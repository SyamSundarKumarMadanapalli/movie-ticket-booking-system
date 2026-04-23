package com.syamsundar.moviebooking.booking;

import com.syamsundar.moviebooking.common.enums.SeatStatus;
import com.syamsundar.moviebooking.common.exception.ConflictException;
import com.syamsundar.moviebooking.showseat.ShowSeat;
import com.syamsundar.moviebooking.showseat.ShowSeatRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SeatLockService {

    private final ShowSeatRepository showSeatRepository;

    @Transactional
    public void lockSeats(UUID showId, List<UUID> seatIds){

        List<ShowSeat> seats = showSeatRepository.findSeatsForUpdate(showId, seatIds);

        if(seats.size()!= seatIds.size()){
            throw new ConflictException("Some seats are not found");
        }

        for(ShowSeat ss : seats){
            if(ss.getStatus() != SeatStatus.AVAILABLE){
                throw new ConflictException("Some seats are already booked or locked");
            }

            ss.setStatus(SeatStatus.LOCKED);
            ss.setLockedAt(LocalDateTime.now());
        }
    }
}
