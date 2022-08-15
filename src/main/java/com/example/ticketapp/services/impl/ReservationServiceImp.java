package com.example.ticketapp.services.impl;

import com.example.ticketapp.model.Reservation;
import com.example.ticketapp.repositories.CustomerRepository;
import com.example.ticketapp.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImp {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CustomerRepository customerRepository;

//    @Override
//    public Reservation makeReservation(){
//
//    }

}
