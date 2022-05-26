package com.example.lab14.repos;

import com.example.lab14.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Integer> {
    List<Patient> findAllByFirstName(String firstName);

    List<Patient> findAllByLastName(String lastName);

    Patient findByPosition(int position);
}
