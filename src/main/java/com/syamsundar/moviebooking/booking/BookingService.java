package com.syamsundar.moviebooking.booking;

import com.syamsundar.moviebooking.common.enums.BookingStatus;
import com.syamsundar.moviebooking.common.enums.SeatStatus;
import com.syamsundar.moviebooking.common.exception.ConflictException;
import com.syamsundar.moviebooking.show.Show;
import com.syamsundar.moviebooking.show.ShowRepository;
import com.syamsundar.moviebooking.showseat.ShowSeat;
import com.syamsundar.moviebooking.showseat.ShowSeatRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ShowSeatRepository showSeatRepository;
    private final ShowRepository showRepository;

    @Transactional
    public Booking createBooking(UUID showId, List<UUID> showSeatIds){

        Show show = showRepository.findById(showId).orElseThrow(() -> new RuntimeException(("Show not found")));

        List<ShowSeat> seats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat ss : seats){
            if(ss.getStatus() != SeatStatus.LOCKED){
                throw new ConflictException("Seats must be locked before booking");
            }
        }

        Booking booking = new Booking();
        booking.setShow(show);
        booking.setShowSeats(seats);
        booking.setStatus(BookingStatus.PAYMENT_PENDING);

        return bookingRepository.save(booking);
    }


    @Transactional
    public void confirmBooking(UUID bookingId){

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking is not found"));

        for(ShowSeat ss : booking.getShowSeats()){
            ss.setStatus(SeatStatus.BOOKED);
        }

        booking.setStatus(BookingStatus.CONFIRMED);
    }
}
