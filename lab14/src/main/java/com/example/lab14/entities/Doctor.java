package com.example.lab14.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String FirstName;
    private String LastName;
    @OneToMany
    private List<Patient> patientList;

    public Doctor(){}

    public Doctor(String firstName, String lastName, List patientList) {
        FirstName = firstName;
        LastName = lastName;
        this.patientList = patientList;
    }
}
