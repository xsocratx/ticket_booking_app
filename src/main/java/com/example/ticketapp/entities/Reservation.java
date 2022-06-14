package com.example.ticketapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "reservation")
@Table(name = "RESERVATION")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;




    public Reservation(){
    }

}
