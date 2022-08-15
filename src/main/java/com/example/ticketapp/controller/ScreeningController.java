package com.example.ticketapp.controller;

import com.example.ticketapp.dto.AuditoriumSeatDto;
import com.example.ticketapp.model.Customer;
import com.example.ticketapp.model.ScheduledMovie;
import com.example.ticketapp.model.Seat;
import com.example.ticketapp.services.impl.CustomerServiceImpl;
import com.example.ticketapp.services.impl.ScheduledMovieInfServiceImpl;
import com.example.ticketapp.services.impl.ScheduledMovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/cinema")
public class ScreeningController {

    @Autowired
    private ScheduledMovieServiceImpl scheduledMovieService;

    @Autowired
    private ScheduledMovieInfServiceImpl scheduledMovieInfService;
    @Autowired
    private CustomerServiceImpl customerService;

//    @Autowired
//    private FilmRepository filmRepository;

        @GetMapping(value = "/scheduled-movies")
    public List<ScheduledMovie> findAllScheduledMovie() {
        return this.scheduledMovieService.findAll();
    }

    @GetMapping(value = "/scheduled-movie/{id}")
    public ScheduledMovie findScreeningById(@PathVariable Integer id) {
        return this.scheduledMovieService.findById(id);
    }

    @GetMapping(value = "/scheduled-movie-inf/{id}")
    public AuditoriumSeatDto findInf(@PathVariable Integer id) {
        return this.scheduledMovieInfService.getScheduledMovieInformation(id);
    }


//    @GetMapping("/screenings-by-time")
//    public List<ScreeningDto> findScreeningsByDateTime(@RequestParam String day, @RequestParam String time){
//        return this.screeningService.findScreeningsByDayTime(day, time);
//    }
//
//    @GetMapping("/screenings-by-timeinterval")
//    public List<ScreeningDto> findScreeningsByDateTime(@RequestParam String day, @RequestParam String time1, @RequestParam String time2){
//        return this.screeningService.findScreeningsByDayTimeInterval(day, time1, time2);
//    }
//
//    @GetMapping("/films")
//    public List<Film> findAllFilms() {return filmRepository.findAll(); }
//
////    @GetMapping("/hall-seats/{id}")
////    public AuditoriumSeatDto getHallSeatByScreeningId(@PathVariable Integer id) {
////        return this.screeningService.getHallSeatByScreeningId(id);
////    }

    @PostMapping(value = "/save-customers")
    Customer newCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

}
