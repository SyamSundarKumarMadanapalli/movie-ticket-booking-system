package com.syamsundar.moviebooking.seat;

import com.syamsundar.moviebooking.common.exception.ConflictException;
import com.syamsundar.moviebooking.common.exception.ResourceNotFoundException;
import com.syamsundar.moviebooking.screen.Screen;
import com.syamsundar.moviebooking.screen.ScreenRepository;
import com.syamsundar.moviebooking.seat.dto.CreateSeatLayoutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;
    private final ScreenRepository screenRepository;

    public void createSeatLayout(CreateSeatLayoutRequest request){
        Screen screen = screenRepository.findById(request.getScreenId())
                .orElseThrow(() -> new ResourceNotFoundException("Screen not found"));

        boolean alreadyExists = seatRepository.existsByScreen_Id(screen.getId());

        if(alreadyExists){
            throw new ConflictException("Seat Layout already exists for this screen");
        }

        int rows = request.getNumberOfRows();
        int seatsPerRow = request.getSeatsPerRow();

        for(int i = 0; i < rows; i++){
            char rowChar = (char) ('A' +  i);

            for(int j = 1; j <= seatsPerRow; j++){
                Seat seat = new Seat();
                seat.setRowNumber(String.valueOf(rowChar));
                seat.setSeatNumber(j);
                seat.setScreen(screen);

                seatRepository.save(seat);
            }
        }
    }
}
