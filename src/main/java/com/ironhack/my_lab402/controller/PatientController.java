package com.ironhack.my_lab402.controller;

import com.ironhack.my_lab402.data.model.Doctor;
import com.ironhack.my_lab402.data.model.Patient;
import com.ironhack.my_lab402.data.reveive.request.DoctorRequest;
import com.ironhack.my_lab402.data.reveive.request.PatientRequest;
import com.ironhack.my_lab402.data.reveive.response.MessageResponse;
import com.ironhack.my_lab402.exception.ResourceNotFoundException;
import com.ironhack.my_lab402.service.DoctorService;
import com.ironhack.my_lab402.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> patients = patientService.getAllPatient();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/find/{patient_Id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("patient_Id") Integer patient_Id) throws ResourceNotFoundException {
        Patient patient = patientService.getASinglePatient(patient_Id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

//    @GetMapping("/find/{date_of_birth}")
//    public ResponseEntity<Patient> getPatientDateOfBirth(@PathVariable("date_of_birth") Date date_of_birth) throws ResourceNotFoundException {
//        Patient patient = patientService.getPatientByDateOfBirth(date_of_birth);
//        return new ResponseEntity<>(patient, HttpStatus.OK);
//    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addPatient(@RequestBody PatientRequest patient) throws ResourceNotFoundException {
        MessageResponse newPatient = patientService.createPatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    @PutMapping("/update/{patient_Id}")
    public Optional<Patient> updatePatient(@PathVariable Integer patient_Id, @RequestBody PatientRequest patient) throws ResourceNotFoundException {
        Optional<Patient> updatePatient = patientService.updatePatient(patient_Id,patient);
        return updatePatient;
    }

    @DeleteMapping("/delete/patient_Id")
    public ResponseEntity<?> deletePatient(@PathVariable("patient_Id") Integer patient_Id) throws ResourceNotFoundException {
        patientService.deletePatient(patient_Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
