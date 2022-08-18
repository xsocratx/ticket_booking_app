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

    @Column(name = "name_movie", length = 70)
    private String nameMovie;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "minutes")
    private Integer minutes;

    @Column(name = "published_year")
    private Integer publishedYear;

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    private List<ScheduledMovie> scheduledMovies;

}
