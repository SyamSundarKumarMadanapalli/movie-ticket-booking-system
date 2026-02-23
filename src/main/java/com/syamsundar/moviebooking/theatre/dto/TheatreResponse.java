package com.syamsundar.moviebooking.theatre.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class TheatreResponse {

    private UUID id;
    private String name;
    private String address;
    private UUID cityId;
}
