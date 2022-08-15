package com.example.ticketapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MOVIE")
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", length = 70, nullable = false)
    private String name;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "minutes", nullable = false)
    private Integer minutes;

    @Column(name = "published_year", nullable = false)
    private Integer publishedYear;

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    private List<ScheduledMovie> scheduledMovies;

}
