package com.syamsundar.moviebooking.booking;

import com.syamsundar.moviebooking.common.enums.SeatStatus;
import com.syamsundar.moviebooking.showseat.ShowSeat;
import com.syamsundar.moviebooking.showseat.ShowSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatCleanupService {

    private final ShowSeatRepository showSeatRepository;

    @Scheduled(fixedRate = 60000)
    public void releaseExpiredLocks(){

        List<ShowSeat> lockedSeats = showSeatRepository.findAll();

        for(ShowSeat ss : lockedSeats){

            if(ss.getStatus() == SeatStatus.LOCKED &&
               ss.getLockedAt().plusMinutes(5).isBefore(LocalDateTime.now())){

                ss.setLockedAt(null);
                ss.setStatus(SeatStatus.AVAILABLE);
            }
        }

        showSeatRepository.saveAll(lockedSeats);
    }
}
