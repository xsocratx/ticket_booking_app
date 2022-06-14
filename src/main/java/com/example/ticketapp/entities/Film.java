package com.example.ticketapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "film")
@Table(name = "FILM")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "description", length = 250)
    private String description;

    public Film(){
    }

    public Film(String title, String description){
        this.title = title;
        this.description = description;
    }

}
