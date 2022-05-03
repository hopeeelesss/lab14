package com.example.lab14.controllers;

import com.example.lab14.entities.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private ArrayList<Patient> patients = new ArrayList<>();

    @GetMapping("/add")
    public String addDoctor(@RequestParam("FirstName") String FirstName ,
                            @RequestParam("LastName") String LastName,
                            @RequestParam("position") int position){
        Patient pat = new Patient();
        pat.setFirstName(FirstName);
        pat.setLastName(LastName);
        pat.setPosition(position);
        patients.add(pat);
        return "completed";
    }

    @GetMapping("/delete")
    public String deleteDoctor(@RequestParam("FirstName") String FirstName ,
                               @RequestParam("LastName") String LastName,
                               @RequestParam("position") int position){
        for(Patient i: patients){
            if(Objects.equals(i.getFirstName(), FirstName)
                    && Objects.equals(i.getLastName(), LastName)
                        && i.getPosition() == position){
                patients.remove(i);
                break;
            }
        }
        return "completed";
    }

    @GetMapping("/list")
    public String listDoctors(){
        for(Patient i: patients){
            System.out.println(i.toString());
        }
        return "completed";
    }

}
