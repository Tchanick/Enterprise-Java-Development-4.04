package com.ironhack.my_lab402.controller;

import com.ironhack.my_lab402.data.model.Doctor;
import com.ironhack.my_lab402.data.reveive.request.DoctorRequest;
import com.ironhack.my_lab402.data.reveive.response.MessageResponse;
import com.ironhack.my_lab402.exception.ResourceNotFoundException;
import com.ironhack.my_lab402.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        List<Doctor> doctors = doctorService.getAllDoctor();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
    @GetMapping("/find/{doctId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctId") Integer doctId) throws ResourceNotFoundException {
        Doctor doctor = doctorService.getASingleDoctor(doctId);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addDoctor(@RequestBody DoctorRequest doctor) throws ResourceNotFoundException {
        MessageResponse newDoctor = doctorService.createDoctor(doctor);
        return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
    }

    @PutMapping("/update/{doctId}")
    public Optional<Doctor> updateDoctor(@PathVariable Integer doctId, @RequestBody DoctorRequest doctor) throws ResourceNotFoundException {
        Optional<Doctor> updateDoctor = doctorService.updateDoctor(doctId, doctor);
        return updateDoctor;
    }

    @DeleteMapping("/delete/{doctId}")
    public ResponseEntity<?> deleteDoctor(@PathVariable("doctId") Integer doctId) throws ResourceNotFoundException {
        doctorService.deleteDoctor(doctId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
