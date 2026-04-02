package com.syamsundar.moviebooking.movie.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class MovieResponse {

    private UUID id;
    private String title;
    private Integer durationInMinutes;
    private String language;
}
