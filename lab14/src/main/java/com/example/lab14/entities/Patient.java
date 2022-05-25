package com.example.lab14.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String FirstName;
    private String LastName;
    private int position;
    @ManyToOne
    @JsonIgnore
    private Doctor doctor;
    public Patient(){}
    public Patient(String firstName, String lastName, int position) {
        FirstName = firstName;
        LastName = lastName;
        this.position = position;
    }
}
