package com.example.ticketapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "ticket")
@Table(name = "TICKET")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "typeTicket")
    private String typeTicket;

    @Column(name = "price")
    private BigDecimal price;

    public Ticket(){
    }

    public Ticket(String typeTicket, BigDecimal price){
    }

}
