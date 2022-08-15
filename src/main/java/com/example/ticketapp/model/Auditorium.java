package com.example.ticketapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AUDITORIUM")
@Getter
@Setter
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false, length = 35)
    private String name;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy = "auditorium")
    @JsonManagedReference
    private List<Row> rows;

    @OneToMany(mappedBy = "auditorium")
    @JsonManagedReference
    private List<ScheduledMovie> scheduledMovies;

}
