package com.syamsundar.moviebooking.seat;

import com.syamsundar.moviebooking.common.entity.BaseEntity;
import com.syamsundar.moviebooking.screen.Screen;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "seats",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_seat_screen_row_number",
                        columnNames = {"screen_id", "row_number", "seat_number"}
                )
        }
)
@Getter
@Setter
public class Seat extends BaseEntity {

    @Column(name = "row_number", nullable = false)
    private String rowNumber;

    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;
}
