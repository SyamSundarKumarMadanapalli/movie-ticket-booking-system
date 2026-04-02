package com.syamsundar.moviebooking.show;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ShowRepository extends JpaRepository<Show, UUID> {

    List<Show> findByScreen_Id(UUID screenId);

    @Query("""
           SELECT s FROM Show s
           WHERE s.screen.id = :screenId
           AND s.startTime < :endTime
           AND s.endTime > :startTime
    """)
    List<Show> findOverlappingShows(
            UUID screenId,
            LocalDateTime startTime,
            LocalDateTime endTime
    );
}
