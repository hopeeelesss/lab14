package com.example.lab14.controllers;

import com.example.lab14.entities.Patient;
import com.example.lab14.services.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/add")
    public String addDoctor(@RequestParam("FirstName") String FirstName ,
                            @RequestParam("LastName") String LastName,
                            @RequestParam("position") int position){
        Patient pat = new Patient();
        pat.setFirstName(FirstName);
        pat.setLastName(LastName);
        pat.setPosition(position);
        patientService.add(pat);
        return "completed";
    }

    @GetMapping("/delete")
    public String deleteDoctor(@RequestParam("FirstName") String FirstName ,
                               @RequestParam("LastName") String LastName,
                               @RequestParam("position") int position){
        Patient pat = new Patient();
        pat.setFirstName(FirstName);
        pat.setLastName(LastName);
        pat.setPosition(position);
        patientService.delete(pat);
        return "completed";
    }

    @GetMapping("/list")
    public String listDoctors(){
        patientService.list();
        return "completed";
    }

}
