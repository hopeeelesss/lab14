package com.example.lab14.services;

import com.example.lab14.entities.Patient;
import com.example.lab14.repos.PatientRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PatientService {
    private final PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public void add(Patient patient){
        patientRepo.save(patient);
    }

    public void delete(Patient patient){
        patientRepo.delete(patient);
    }

    public void list(){
        for(Patient patient: patientRepo.findAll()){
            System.out.println(patient);
        }
    }
}
