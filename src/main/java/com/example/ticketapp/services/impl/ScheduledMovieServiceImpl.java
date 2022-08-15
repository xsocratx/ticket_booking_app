package com.example.ticketapp.services.impl;

import com.example.ticketapp.exception.ResourceNotFoundException;
import com.example.ticketapp.model.ScheduledMovie;
import com.example.ticketapp.repositories.ScheduledMovieRepository;
import com.example.ticketapp.services.ScheduledMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduledMovieServiceImpl implements ScheduledMovieService {

    @Autowired
    private final ScheduledMovieRepository scheduledMovieRepository;

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

//    @Override
//    public List<ScreeningDto> findScreeningsByDayTime(String day, String time){
//        List<ScreeningDto> findScreenings = new ArrayList<>();
//        List<Screening> screenings = (List<Screening>) this.screeningRepository.findAll();
//        for(Screening screening: screenings){
//            if(String.valueOf(screening.getDay()).equals(day) && time.equals(String.valueOf(screening.getTime()))){
//                    String nameFilm = screening.getFilm().getName();
//                    findScreenings.add(new ScreeningDto(screening.getId()
//                            ,screening.getDay()
//                            ,screening.getTime()
//                            , nameFilm));
//            }
//        }
//        return findScreenings;
//    }
//
//    @Override
//    public List<ScreeningDto> findScreeningsByDayTimeInterval(String day, String time1, String time2){
//        List<ScreeningDto> findScreenings = new ArrayList<>();
//        List<Screening> screenings = (List<Screening>) this.screeningRepository.findAll();
//        LocalTime time1parse = LocalTime.parse(time1);
//        LocalTime time2parse = LocalTime.parse(time2);
//        for(Screening screening: screenings){
//            if(String.valueOf(screening.getDay()).equals(day) &&
//                    screening.getTime().isAfter(time1parse) &&
//                        screening.getTime().isBefore(time2parse)){
//                String nameFilm = screening.getFilm().getName();
//                findScreenings.add(new ScreeningDto(screening.getId()
//                        , screening.getDay()
//                        , screening.getTime()
//                        , nameFilm));
//            }
//        }
//        return findScreenings;
//    }


}
