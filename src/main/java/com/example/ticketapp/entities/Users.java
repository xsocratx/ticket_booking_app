package com.example.ticketapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "users")
@Table(name = "USERS")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname", length = 100)
    private String surname;

    public Users(){
    }

    public Users(String name, String surName){
        this.name = name;
        this.surname = surName;
    }

}

