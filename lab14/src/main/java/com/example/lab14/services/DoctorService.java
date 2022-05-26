package com.example.lab14.services;

import com.example.lab14.entities.Doctor;
import com.example.lab14.repos.DoctorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
@Slf4j
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private EmailService emailService;


    public void add(Doctor doctor){
        log.info("Added {}", doctor);
        doctorRepo.save(doctor);
        emailService.sendMessage("Doctor", doctor.toString());
    }

    public void delete(Doctor doctor){
        log.info("Deleted {}",doctor);
        doctorRepo.delete(doctor);
    }

    public void list(){
        log.info("Listed Doctors");
        for(Doctor doctor: doctorRepo.findAll()){
            System.out.println(doctor);
        }
    }


}
