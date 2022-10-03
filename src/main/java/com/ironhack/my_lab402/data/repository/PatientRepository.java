package com.ironhack.my_lab402.data.repository;

import com.ironhack.my_lab402.data.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
