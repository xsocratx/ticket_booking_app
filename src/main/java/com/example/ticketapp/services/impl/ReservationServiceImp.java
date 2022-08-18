package com.example.ticketapp.services.impl;

import com.example.ticketapp.dto.ReservationDto;
import com.example.ticketapp.model.Customer;
import com.example.ticketapp.model.Reservation;
import com.example.ticketapp.model.ReservationType;
import com.example.ticketapp.repositories.CustomerRepository;
import com.example.ticketapp.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReservationServiceImp {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public void makeReservation(ReservationDto reservationDto){

        Integer scheduledMovieId = reservationDto.getScheduledMovieId();
        String firstNameCustomer = reservationDto.getFirstName();
        String lastNameCustomer = reservationDto.getLastName();
        Map<String, String> seatIdTypes = new HashMap<>();
//save Customer
        Customer customer = saveCustomer(firstNameCustomer, lastNameCustomer);
        Integer customerId = customer.getId();
//create Reservation
        for (String seatIdstr:
                seatIdTypes.keySet()) {
            String stringKey = seatIdTypes.get(seatIdstr);
            ReservationType type = ReservationType.valueOf(stringKey);
            Integer seatId = null;
            try {
                seatId = Integer.parseInt(seatIdstr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            this.reservationRepository.save(new Reservation(scheduledMovieId, customerId, seatId, type));
        }
    }

    public Customer saveCustomer(String firstName, String lastName){
        return this.customerRepository.save(new Customer(firstName, lastName));
    }

}
