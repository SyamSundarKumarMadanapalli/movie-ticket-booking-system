package com.syamsundar.moviebooking.booking;

import com.syamsundar.moviebooking.common.entity.BaseEntity;
import com.syamsundar.moviebooking.common.enums.BookingStatus;
import com.syamsundar.moviebooking.show.Show;
import com.syamsundar.moviebooking.showseat.ShowSeat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "bookings")
@Getter
@Setter
public class Booking extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    @ManyToMany
    @JoinTable(
            name = "booking_show_seats",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "show_seat_id")
    )
    private List<ShowSeat> showSeats;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private Double totalAmount;
}
