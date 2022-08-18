package com.example.ticketapp.services.impl;

import com.example.ticketapp.dto.ScheduledMovieDto;
import com.example.ticketapp.exception.ResourceNotFoundException;
import com.example.ticketapp.model.Auditorium;
import com.example.ticketapp.model.Movie;
import com.example.ticketapp.model.ScheduledMovie;
import com.example.ticketapp.repositories.AuditoriumRepository;
import com.example.ticketapp.repositories.MovieRepository;
import com.example.ticketapp.repositories.ScheduledMovieRepository;
import com.example.ticketapp.services.ScheduledMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduledMovieServiceImpl implements ScheduledMovieService {

    @Autowired
    private final ScheduledMovieRepository scheduledMovieRepository;
    @Autowired
    private final MovieRepository movieRepository;
    @Autowired
    private final AuditoriumRepository auditoriumRepository;

    @Override
    public List<ScheduledMovie> findAll(){
        return (List<ScheduledMovie>) this.scheduledMovieRepository.findAll();
    }

    @Override
    public ScheduledMovie findById(Integer id){
        return this.scheduledMovieRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Screening not found"));
    }

    @Override
    public List<ScheduledMovieDto> findScheduledMovieByDateTime(String dateTimeStr){
        List<ScheduledMovieDto> scheduledMovieDtos = new ArrayList<>();

//Convert string to LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);

//Find all ScreenigMovies by dateTime
        List<ScheduledMovie> scheduledMovies = this.scheduledMovieRepository.findAll()
                .stream().filter(scheduledMovie -> scheduledMovie.getStartOf().isEqual(dateTime)).toList();
//Get List of ScheduledMovieDto
        for (ScheduledMovie scheduledMovie: scheduledMovies) {

            String nameMovie = getNameMovie(scheduledMovie);
            String nameAuditorium = getNameAuditorium((scheduledMovie));
            LocalDateTime dateTimeMovie = scheduledMovie.getStartOf();

            scheduledMovieDtos.add(new ScheduledMovieDto(scheduledMovie.getId(), nameMovie, dateTimeMovie, nameAuditorium));
        }
        return scheduledMovieDtos;
    }

    public String getNameMovie(ScheduledMovie scheduledMovie){
        Integer idMovie = scheduledMovie.getMovieId();
        Optional<Movie> movie = this.movieRepository.findById(idMovie);
        String nameMovie = movie.get().getNameMovie();
        return nameMovie;
    }

    public String getNameAuditorium(ScheduledMovie scheduledMovie){
        Integer idAuditorium = scheduledMovie.getAuditoriumId();
        Optional<Auditorium> auditorium = this.auditoriumRepository.findById(idAuditorium);
        String nameAuditorium = auditorium.get().getName();
        return nameAuditorium;
    }


}
