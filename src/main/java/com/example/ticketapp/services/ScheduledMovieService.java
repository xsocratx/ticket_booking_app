package com.example.ticketapp.services;

import com.example.ticketapp.model.ScheduledMovie;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ScheduledMovieService {

    List<ScheduledMovie> findAll();
    ScheduledMovie findById(Integer id);
//    List<ScheduledMovie> findScreeningsByDayTime(String day, String time);
//    List<ScheduledMovie> findScreeningsByDayTimeInterval(String day, String time1, String time2);



}
