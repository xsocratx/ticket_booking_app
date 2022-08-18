package com.example.ticketapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
@JsonIgnoreProperties({"reservations"})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "The first name is requared")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "The last name is requared")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Reservation> reservations;

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
