package com.example.ticketapp.services.impl;

import com.example.ticketapp.dto.AuditoriumSeatDto;
import com.example.ticketapp.model.*;
import com.example.ticketapp.repositories.*;
import com.example.ticketapp.services.ScheduledMovieInfService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduledMovieInfServiceImpl implements ScheduledMovieInfService {

    @Autowired
    private final ScheduledMovieRepository scheduledMovieRepository;
    @Autowired
    private final AuditoriumRepository auditoriumRepository;
    @Autowired
    private final RowRepository rowRepository;
    @Autowired
    private final SeatRepository seatRepository;
    @Autowired
    private final ReservationRepository reservationRepository;

    @Override
    public AuditoriumSeatDto getScheduledMovieInformation(Integer scheduleMovieId){
        String nameAuditorium;
        Map<String, List<Integer>> freeSeats = new HashMap<>();

//Get name of Auditorium
        Integer auditoriumId;
        Optional<ScheduledMovie> scheduledMovie = this.scheduledMovieRepository.findById(scheduleMovieId);
        auditoriumId = scheduledMovie.get().getAuditoriumId();
        Optional<Auditorium> auditorium = this.auditoriumRepository.findById(auditoriumId);
        nameAuditorium = auditorium.get().getName();

//Get all rows of Auditorium
        List<Row> rowsInAuditorium = this.rowRepository.findAll().stream()
                .filter(row -> row.getAuditoriumId() == auditoriumId).toList();
//Get name all rows of Auditorium
        List<String> rowsNameInAuditorium = new ArrayList<>();
        for(Row row: rowsInAuditorium){
            rowsNameInAuditorium.add(row.getName());
        }
//Get id all rows of Auditorium
        List<Integer> rowsIdInAuditorium = new ArrayList<>();
        rowsIdInAuditorium = rowsInAuditorium.stream().map(Row::getId).collect(Collectors.toList());

//Get seats Number from Row
        List<List<Integer>> seatsInRow = new ArrayList<>();
        for(Integer rowId: rowsIdInAuditorium) {
            seatsInRow.add(this.seatRepository.findAll().stream()
                    .filter(seat -> seat.getRowId() == rowId)
                    .map(Seat::getNumber)
                    .collect(Collectors.toList()));
        }

//Get map
        Iterator iterRow = rowsNameInAuditorium.iterator();
        Iterator iterSeats = seatsInRow.iterator();

        while (iterRow.hasNext() && iterSeats.hasNext()){
            String nameRow = (String) iterRow.next();
            List<Integer> element = (List<Integer>) iterSeats.next();
            freeSeats.put(nameRow, element);
        }

        AuditoriumSeatDto auditoriumSeatDto = new AuditoriumSeatDto(nameAuditorium, freeSeats);
        return auditoriumSeatDto;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Get auditoriumId of ScheduledMovie
    private Integer getScheduledMovieAuditoriumId(Integer scheduleMovieId){
        Optional<ScheduledMovie> scheduledMovie = this.scheduledMovieRepository.findById(scheduleMovieId);
        Integer auditoriumId = scheduledMovie.get().getAuditoriumId();
        return auditoriumId;
    }

//Get auditoriumName of ScheduledMovie
    private String getScheduledMovieAuditoriumName(Integer auditoriumId){
        Optional<Auditorium> auditorium = this.auditoriumRepository.findById(auditoriumId);
        String nameAuditorium = auditorium.get().getName();
        return nameAuditorium;
    }

//Get rowIds in auditorium of ScheduledMovie
    private List<Integer> getScheduledMovieRowsId(Integer auditoriumId){
        List<Row> rowsInAuditorium = this.rowRepository.findAll().stream()
                .filter(row -> row.getAuditoriumId() == auditoriumId).toList();
        List<Integer> rowsIdInAuditorium = rowsInAuditorium.stream().map(Row::getId).collect(Collectors.toList());
        return rowsIdInAuditorium;
    }
//Get rowName in auditorium of ScheduledMovie
    private List<String> getScheduledMovieRowsName(Integer auditoriumId){
        List<Row> rowsInAuditorium = this.rowRepository.findAll().stream()
                .filter(row -> row.getAuditoriumId() == auditoriumId).toList();
        List<String> rowsNameInAuditorium = new ArrayList<>();
        for(Row row: rowsInAuditorium){
            rowsNameInAuditorium.add(row.getName());
        }
        return rowsNameInAuditorium;
    }

//Get seatsId in row of ScheduledMovie
    private List<List<Integer>> getAllNumberSeatsInRow(List<Integer> rowsIdInAuditorium){
        List<List<Integer>> numberSeatsInRow = new ArrayList<>();
        for(Integer rowId: rowsIdInAuditorium) {
            numberSeatsInRow.add(this.seatRepository.findAll().stream()
                    .filter(seat -> seat.getRowId() == rowId)
                    .map(Seat::getId)
                    .collect(Collectors.toList()));
        }
        return numberSeatsInRow;
    }

//Get occupied seats from reservation of ScheduledMovie
    private List<Integer> getOccupiedSeatsReservation(Integer scheduledMovieId){
        List<Reservation> occupiedSeatForScheduledMovie = this.reservationRepository.findAll()
            .stream().filter(seat ->seat.getScheduledMovieId() == scheduledMovieId).toList();
        List<Integer> occupiedSeats = occupiedSeatForScheduledMovie.stream().map(Reservation::getSeatId).toList();
        return occupiedSeats;
    }

//
    private List<Integer> getFreeNumberSeatsScheduledMovie(List<Integer> occupiedNumberOfSeats, List<Integer> allNumberOfSeats){
        allNumberOfSeats.removeAll(occupiedNumberOfSeats);
        return allNumberOfSeats;
    }

//Get free seatsId
    private List<List<Integer>> getFreeIdSeatsScheduledMovie(List<List<Integer>> allSeatsId, List<Integer> occupiedSeatsId){
        for(List<Integer> seatsIdInRow: allSeatsId){
            seatsIdInRow.removeAll(occupiedSeatsId);
        }
        return allSeatsId;
    }
//Create map with AuditoriumName and FreeSeats
    private Map<String, List<Integer>> getFreeSeatInRow(List<String> rowsNameInAuditorium, List<List<Integer>> seatsInRow){
        Map<String, List<Integer>> freeSeats = new HashMap<>();
        Iterator iterRow = rowsNameInAuditorium.iterator();
        Iterator iterSeats = seatsInRow.iterator();

        while (iterRow.hasNext() && iterSeats.hasNext()){
            String nameRow = (String) iterRow.next();
            List<Integer> element = (List<Integer>) iterSeats.next();
            freeSeats.put(nameRow, element);
        }
        return freeSeats;
    }


}
