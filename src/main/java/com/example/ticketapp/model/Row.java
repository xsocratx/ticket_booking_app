package com.example.ticketapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROW")
@Getter
@Setter
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "seat_in_row", nullable = false)
    private Integer seatsInRow;

    @Column(name = "auditorium_id", nullable = false, insertable = false, updatable = false)
    private Integer auditoriumId;

    @ManyToOne
    @JoinColumn(name = "auditorium_id", nullable = false)
    @JsonBackReference
    private Auditorium auditorium;

    @OneToMany(mappedBy = "row")
    @JsonManagedReference
    private List<Seat> seats;

}
