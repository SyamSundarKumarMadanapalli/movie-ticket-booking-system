package com.syamsundar.moviebooking.show.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class ShowResponse {

    private UUID id;
    private UUID movieId;
    private UUID screenId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
