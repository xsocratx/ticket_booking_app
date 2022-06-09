package com.example.ticketapp.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "film")
@Table(name = "FILM")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "description", length = 250)
    private String description;


}
