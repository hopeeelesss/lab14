package com.example.lab14.repos;

import com.example.lab14.entities.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends CrudRepository<Doctor,Integer> {
}
