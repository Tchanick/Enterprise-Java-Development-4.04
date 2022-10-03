package com.ironhack.my_lab402.service;

import com.ironhack.my_lab402.data.model.Patient;
import com.ironhack.my_lab402.data.reveive.request.PatientRequest;
import com.ironhack.my_lab402.data.reveive.response.MessageResponse;
import com.ironhack.my_lab402.exception.ResourceNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    MessageResponse createPatient(PatientRequest patientRequest);
    Optional<Patient> updatePatient(Integer patId, PatientRequest patientRequest) throws ResourceNotFoundException;
    void deletePatient(Integer patId) throws ResourceNotFoundException;
    Patient getASinglePatient(Integer patId) throws ResourceNotFoundException;
//    Patient getPatientByDateOfBirth(Date patDateOfBirth) throws ResourceNotFoundException;
    List<Patient> getAllPatient();
}
