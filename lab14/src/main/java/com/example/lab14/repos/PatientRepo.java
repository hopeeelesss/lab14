package com.example.lab14.repos;

import com.example.lab14.entities.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends CrudRepository<Patient,Integer> {
}
