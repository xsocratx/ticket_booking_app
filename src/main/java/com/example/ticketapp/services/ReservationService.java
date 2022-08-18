package com.example.ticketapp.services;

import com.example.ticketapp.dto.ReservationDto;
import com.example.ticketapp.model.Reservation;

public interface ReservationService {

    void makeReservation(ReservationDto reservationDto);
}
