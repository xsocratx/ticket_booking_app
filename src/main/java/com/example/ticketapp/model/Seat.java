package com.example.ticketapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SEAT")
@Setter
@Getter
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "row_id", nullable = false, insertable = false, updatable = false)
    private Integer rowId;

    @ManyToOne
    @JoinColumn(name = "row_id", nullable = false)
    @JsonBackReference
    private Row row;

}
