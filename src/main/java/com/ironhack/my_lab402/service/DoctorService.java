package com.ironhack.my_lab402.service;

import com.ironhack.my_lab402.data.model.Doctor;
import com.ironhack.my_lab402.data.reveive.request.DoctorRequest;
import com.ironhack.my_lab402.data.reveive.response.MessageResponse;
import com.ironhack.my_lab402.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DoctorService {
    MessageResponse createDoctor(DoctorRequest doctorRequest);
    Optional<Doctor> updateDoctor(Integer doctId, DoctorRequest doctorRequest) throws ResourceNotFoundException;
    void deleteDoctor(Integer doctId) throws ResourceNotFoundException;
    Doctor getASingleDoctor(Integer doctId) throws ResourceNotFoundException;
    List<Doctor> getAllDoctor();
}
