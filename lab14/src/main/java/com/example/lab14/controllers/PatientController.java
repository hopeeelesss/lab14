package com.example.lab14.controllers;

import com.example.lab14.entities.Patient;
import com.example.lab14.repos.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;

@Controller
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientRepo patientRepo;

    @GetMapping("/add")
    public String addDoctor(@RequestParam("FirstName") String FirstName ,
                            @RequestParam("LastName") String LastName,
                            @RequestParam("position") int position){
        Patient pat = new Patient();
        pat.setFirstName(FirstName);
        pat.setLastName(LastName);
        pat.setPosition(position);
        patientRepo.save(pat);
        return "completed";
    }

    @GetMapping("/delete")
    public String deleteDoctor(@RequestParam("FirstName") String FirstName ,
                               @RequestParam("LastName") String LastName,
                               @RequestParam("position") int position){
        for(Patient patient: patientRepo.findAll()){
            if(Objects.equals(patient.getFirstName(), FirstName)
                    && Objects.equals(patient.getLastName(), LastName)
                        && patient.getPosition() == position){
                patientRepo.delete(patient);
                break;
            }
        }
        return "completed";
    }

    @GetMapping("/list")
    public String listDoctors(){
        for(Patient patient: patientRepo.findAll()){
            System.out.println(patient.toString());
        }
        return "completed";
    }

}
