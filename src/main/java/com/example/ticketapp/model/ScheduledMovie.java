package com.example.ticketapp.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SCHEDULED_MOVIE")
@JsonIgnoreProperties({"movieId", "auditoriumId", "reservations"})
@Getter
@Setter
public class ScheduledMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "start_of", nullable = false)
    private LocalDateTime startOf;

    @Column(name = "end_of",nullable = false)
    private LocalDateTime endOf;

    @Column(name = "movie_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty("movieId")
    private Integer movieId;

    @Column(name = "auditorium_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty("auditoriumId")
    private Integer auditoriumId;

    @ManyToOne
    @JoinColumn(name = "auditorium_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Auditorium auditorium;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Movie movie;

    @OneToMany(mappedBy = "scheduledMovie")
    @JsonManagedReference
    private List<Reservation> reservations;

}
