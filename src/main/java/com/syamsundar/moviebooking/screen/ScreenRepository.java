package com.syamsundar.moviebooking.screen;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScreenRepository extends JpaRepository<Screen, UUID> {
}
