package com.syamsundar.moviebooking.showseat;

import com.syamsundar.moviebooking.common.entity.BaseEntity;
import com.syamsundar.moviebooking.common.enums.SeatStatus;
import com.syamsundar.moviebooking.seat.Seat;
import com.syamsundar.moviebooking.show.Show;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "show_seats",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"show_id", "seat_id"})
        }
)
@Getter
@Setter
public class ShowSeat extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatStatus status;

    private LocalDateTime lockedAt;
}
