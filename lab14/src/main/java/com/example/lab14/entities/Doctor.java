package com.example.lab14.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String FirstName;
    private String LastName;

    public Doctor(){}

    public Doctor(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }
}
