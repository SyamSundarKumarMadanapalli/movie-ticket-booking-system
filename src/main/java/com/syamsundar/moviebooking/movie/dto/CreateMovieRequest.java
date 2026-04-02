package com.syamsundar.moviebooking.movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMovieRequest {

    @NotBlank
    private String title;

    @NotNull
    private Integer durationInMinutes;

    @NotBlank
    private String language;
}
