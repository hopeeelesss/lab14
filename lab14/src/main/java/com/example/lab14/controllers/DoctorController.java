package com.example.lab14.controllers;

import com.example.lab14.entities.Doctor;
import com.example.lab14.repos.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorRepo doctorRepo;

    @GetMapping("/add")
    public String addDoctor(@RequestParam("FirstName") String FirstName ,
                            @RequestParam("LastName") String LastName){
        Doctor doc = new Doctor();
        doc.setFirstName(FirstName);
        doc.setLastName(LastName);
        doctorRepo.save(doc);
        return "completed";
    }

    @GetMapping("/delete")
    public String deleteDoctor(@RequestParam("FirstName") String FirstName ,
                            @RequestParam("LastName") String LastName){
        for(Doctor doctor: doctorRepo.findAll()){
            if(Objects.equals(doctor.getFirstName(), FirstName)
            && Objects.equals(doctor.getLastName(), LastName)){
                doctorRepo.delete(doctor);
                break;
            }
        }
        return "completed";
    }

    @GetMapping("/list")
    public String listDoctors(){
        for(Doctor i: doctorRepo.findAll()){
            System.out.println(i.toString());
        }
        return "completed";
    }

}
