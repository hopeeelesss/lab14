package com.example.lab14.services;

import com.example.lab14.entities.Patient;
import com.example.lab14.repos.PatientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private EmailService emailService;

    public void add(Patient patient){
        log.info("Added {}", patient);
        emailService.sendMessage("Patient", patient.toString());
        patientRepo.save(patient);
    }

    public void delete(Patient patient){
        log.info("Deleted {}", patient);
        patientRepo.delete(patient);
    }

    public void list(){
        log.info("Listed Patients");
        for(Patient patient: patientRepo.findAll()){
            System.out.println(patient);
        }
    }
}
