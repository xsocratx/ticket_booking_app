package com.example.ticketapp.dto;

import com.example.ticketapp.model.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class AuditoriumSeatDto {

    private String auditoriumName;
    private Map<String, List<Integer>> seats;

}
