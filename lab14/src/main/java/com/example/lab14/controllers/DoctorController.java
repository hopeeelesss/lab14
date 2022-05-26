package com.example.lab14.controllers;

import com.example.lab14.entities.Doctor;
import com.example.lab14.services.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    public final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @GetMapping("/add")
    public String addDoctor(@RequestParam("FirstName") String FirstName ,
                            @RequestParam("LastName") String LastName){
        Doctor doc = new Doctor();
        doc.setFirstName(FirstName);
        doc.setLastName(LastName);
        doctorService.add(doc);
        return "completed";
    }

    @GetMapping("/delete")
    public String deleteDoctor(@RequestParam("FirstName") String FirstName ,
                            @RequestParam("LastName") String LastName){
        Doctor doc = new Doctor();
        doc.setFirstName(FirstName);
        doc.setLastName(LastName);
        doctorService.delete(doc);
        return "completed";
    }

    @GetMapping("/list")
    public String listDoctors(){
        doctorService.list();
        return "completed";
    }

}
