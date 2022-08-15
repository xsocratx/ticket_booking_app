package com.example.ticketapp.dto;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class ScheduledMovieInfDto {

    private String nameAuditorium;

    private Map<String, List<Integer>> freeSeats;

}
