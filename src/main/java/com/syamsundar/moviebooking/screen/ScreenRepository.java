package com.syamsundar.moviebooking.screen;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ScreenRepository extends JpaRepository<Screen, UUID> {

    List<Screen> findByTheatre_Id(UUID theatreId);
}
