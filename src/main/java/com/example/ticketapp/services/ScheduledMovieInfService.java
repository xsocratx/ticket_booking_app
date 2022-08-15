package com.example.ticketapp.services;

import com.example.ticketapp.dto.AuditoriumSeatDto;

public interface ScheduledMovieInfService {
    AuditoriumSeatDto getScheduledMovieInformation(Integer id);
}
