package com.example.ticketapp.entities;


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
    @Column(name = "id")
    private Long id;

    @Column(name = "numberRoom")
    private Integer numberRoom;

    @Column(name = "description", length = 250)
    private String description;

    public Room(){
    }

    public Room(Integer numberRoom, String description){
        this.numberRoom = numberRoom;
        this.description = description;
    }

}
