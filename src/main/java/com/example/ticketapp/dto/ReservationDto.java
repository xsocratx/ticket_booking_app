package com.example.ticketapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationDto {

    private Integer scheduledMovieId;
    private Map<String, String> seatIdTypes;
    private String firstName;
    private String lastName;

}
