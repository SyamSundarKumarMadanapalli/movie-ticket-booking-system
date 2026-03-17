package com.syamsundar.moviebooking.screen.dto;

import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class ScreenResponse {

    private UUID id;
    private String name;
    private Integer totalSeats;
    private UUID theatreId;
}
