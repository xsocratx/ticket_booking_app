package com.example.ticketapp.controller;

import com.example.ticketapp.dto.AuditoriumSeatDto;
import com.example.ticketapp.dto.ReservationDto;
import com.example.ticketapp.dto.ScheduledMovieDto;
import com.example.ticketapp.model.Customer;
import com.example.ticketapp.model.ScheduledMovie;
import com.example.ticketapp.services.impl.ReservationServiceImp;
import com.example.ticketapp.services.impl.ScheduledMovieInfServiceImpl;
import com.example.ticketapp.services.impl.ScheduledMovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cinema")
public class ScheduledMovieController {

    @Autowired
    private ScheduledMovieServiceImpl scheduledMovieService;
    @Autowired
    private ScheduledMovieInfServiceImpl scheduledMovieInfService;
    @Autowired
    private ReservationServiceImp reservationService;

    @GetMapping("/scheduled-movies")
    public List<ScheduledMovie> findAllScheduledMovie() {
        return this.scheduledMovieService.findAll();
    }

    @GetMapping("/scheduled-movie/{id}")
    public ScheduledMovie findScreeningById(@PathVariable Integer id) {
        return this.scheduledMovieService.findById(id);
    }

    @GetMapping("/scheduled-movie-inf/{id}")
    public AuditoriumSeatDto findInf(@PathVariable Integer id) {
        return this.scheduledMovieInfService.getScheduledMovieInformation(id);
    }

    @GetMapping("/scheduled-movies-by-datetime")
    public List<ScheduledMovieDto> findScreeningsByDateTime(@RequestParam String dateTimeStr){
        return this.scheduledMovieService.findScheduledMovieByDateTime(dateTimeStr);
    }

    @PostMapping("/make-reservations")
    void newCustomer(@RequestBody ReservationDto reservationDto){
        reservationService.makeReservation(reservationDto);
    }



}
