package com.example.ticketapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RESERVATION")
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "scheduled_movie_id", nullable = false, insertable=false, updatable = false)
    private Integer scheduledMovieId;

    @Column(name = "customer_id", nullable = false, insertable=false, updatable = false)
    private Integer customerId;

    @Column(name = "seat_id", nullable = false, insertable=false, updatable = false)
    private Integer seatId;

    @ManyToOne
    @JoinColumn(name = "scheduled_movie_id", nullable = false)
    @JsonBackReference
    private ScheduledMovie scheduledMovie;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonBackReference
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    @JsonBackReference
    private Seat seat;

    @Column(name = "reservation_type")
    @Enumerated(EnumType.STRING)
    private ReservationType reservationType;

    public Reservation(final Integer scheduledMovieId, final Integer customerId, final Integer seatId, final ReservationType reservationType) {
        this.scheduledMovieId = scheduledMovieId;
        this.customerId = customerId;
        this.seatId = seatId;
        this.reservationType = reservationType;
    }

}
