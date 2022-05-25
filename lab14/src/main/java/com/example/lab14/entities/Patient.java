package com.example.lab14.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String FirstName;
    private String LastName;
    private int position;

    public Patient(){}
    public Patient(String firstName, String lastName, int position) {
        FirstName = firstName;
        LastName = lastName;
        this.position = position;
    }
}
