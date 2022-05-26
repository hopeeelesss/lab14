package com.example.lab14.repos;

import com.example.lab14.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
    List<Doctor> findAllByFirstName(String firstName);

    List<Doctor> findAllByLastName(String lastName);
}
