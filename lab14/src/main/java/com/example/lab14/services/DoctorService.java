package com.example.lab14.services;

import com.example.lab14.entities.Doctor;
import com.example.lab14.repos.DoctorRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class DoctorService {
    private final DoctorRepo doctorRepo;

    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public void add(Doctor doctor){
        doctorRepo.save(doctor);
    }

    public void delete(Doctor doctor){
        doctorRepo.delete(doctor);
    }

    public void list(){
        for(Doctor doctor: doctorRepo.findAll()){
            System.out.println(doctor);
        }
    }


}
