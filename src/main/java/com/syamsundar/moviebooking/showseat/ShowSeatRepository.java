package com.syamsundar.moviebooking.showseat;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, UUID> {

    List<ShowSeat> findByShow_Id(UUID showId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
            SELECT ss FROM ShowSeat ss
            WHERE ss.show.id = :showId
            AND ss.seat.id IN :seatIds
           """)
    List<ShowSeat> findSeatsForUpdate(UUID showId ,List<UUID> seatIds);
}
