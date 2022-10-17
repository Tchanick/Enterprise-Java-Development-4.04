package com.ironhack.my_lab402.service;

import com.ironhack.my_lab402.data.model.Doctor;
import com.ironhack.my_lab402.data.model.Patient;
import com.ironhack.my_lab402.data.repository.DoctorRepository;
import com.ironhack.my_lab402.data.repository.PatientRepository;
import com.ironhack.my_lab402.data.reveive.request.DoctorRequest;
import com.ironhack.my_lab402.data.reveive.request.PatientRequest;
import com.ironhack.my_lab402.data.reveive.response.MessageResponse;
import com.ironhack.my_lab402.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Override
    public MessageResponse createPatient(PatientRequest patientRequest){
        Patient newPatient = new Patient();
        newPatient.setName(patientRequest.getName());
        newPatient.setDate_of_birth(patientRequest.getDate_of_birth());
        Doctor savedDoctor = doctorRepository.save(patientRequest.getDoctor());
        newPatient.setDoctor(savedDoctor);
        patientRepository.save(newPatient);
        return new MessageResponse("New patient created successfully");
    }

    @Override
    public Optional<Patient> updatePatient(Integer patId, PatientRequest patientRequest) throws ResourceNotFoundException {
        Optional<Patient> patient = patientRepository.findById(patId);
        if (patient.isEmpty()){
            throw new ResourceNotFoundException("Patient", "patientId", patId);
        }else {
            patient.get().setName(patientRequest.getName());
            patient.get().setDate_of_birth(patientRequest.getDate_of_birth());
            patient.get().setDoctor(patientRequest.getDoctor());
            patientRepository.save(patient.get());
        }
        return patient;
    }

    @Override
    public Patient getASinglePatient(Integer patId) throws ResourceNotFoundException{
        return patientRepository.findById(patId).orElseThrow(() -> new ResourceNotFoundException("Patient", "patientId", patId));
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public void deletePatient(Integer patId) throws ResourceNotFoundException{
        if (Objects.equals(patientRepository.getById(patId).getPatient_id(), patId)){
            patientRepository.deleteById(patId);
        }else {
            throw new ResourceNotFoundException("Patient", "patientId", patId);
        }
    }

}
