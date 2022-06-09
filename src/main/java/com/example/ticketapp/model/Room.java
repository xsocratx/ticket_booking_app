package com.example.ticketapp.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "room")
@Table(name = "ROOM")
@Getter
@Setter
@EqualsAndHashCode
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;



}
