package com.example.ticketapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ScheduledMovieDto {

    private Integer idScheduledMovie;
    private String nameMovie;
    private LocalDateTime startOf;
    private String nameAuditorium;

}
