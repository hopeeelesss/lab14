package com.example.lab14.controllers;

import com.example.lab14.entities.Doctor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Objects;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    private ArrayList<Doctor> doctors = new ArrayList<>();

    @GetMapping("/add")
    public String addDoctor(@RequestParam("FirstName") String FirstName ,
                            @RequestParam("LastName") String LastName){
        Doctor doc = new Doctor();
        doc.setFirstName(FirstName);
        doc.setLastName(LastName);
        doctors.add(doc);
        return "completed";
    }

    @GetMapping("/delete")
    public String deleteDoctor(@RequestParam("FirstName") String FirstName ,
                            @RequestParam("LastName") String LastName){
        for(Doctor i: doctors){
            if(Objects.equals(i.getFirstName(), FirstName)
            && Objects.equals(i.getLastName(), LastName)){
                doctors.remove(i);
                break;
            }
        }
        return "completed";
    }

    @GetMapping("/list")
    public String listDoctors(){
        for(Doctor i: doctors){
            System.out.println(i.toString());
        }
        return "completed";
    }

}
