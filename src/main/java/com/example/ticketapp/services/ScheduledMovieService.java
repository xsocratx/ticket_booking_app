package com.example.ticketapp.services;

import com.example.ticketapp.dto.ScheduledMovieDto;
import com.example.ticketapp.model.ScheduledMovie;

import java.util.List;
public interface ScheduledMovieService {

    List<ScheduledMovie> findAll();
    ScheduledMovie findById(Integer id);
    List<ScheduledMovieDto> findScheduledMovieByDateTime(String dateTimeStr);


}
