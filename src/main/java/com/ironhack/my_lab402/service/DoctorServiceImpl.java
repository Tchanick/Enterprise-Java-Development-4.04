package com.ironhack.my_lab402.service;

import com.ironhack.my_lab402.data.model.Doctor;
import com.ironhack.my_lab402.data.repository.DoctorRepository;
import com.ironhack.my_lab402.data.reveive.request.DoctorRequest;
import com.ironhack.my_lab402.data.reveive.response.MessageResponse;
import com.ironhack.my_lab402.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Override
    public MessageResponse createDoctor(DoctorRequest doctorRequest){
        Doctor newDoctor = new Doctor();
        newDoctor.setEmployee_id(doctorRequest.getEmployee_id());
        newDoctor.setDepartment(doctorRequest.getDepartment());
        newDoctor.setName(doctorRequest.getName());

        newDoctor.setPatientList(doctorRequest.getPatientList());
        newDoctor.setStatus(doctorRequest.getStatus());
        doctorRepository.save(newDoctor);
        return new MessageResponse("New doctor created successfully");
    }

    @Override
    public Optional<Doctor> updateDoctor(Integer doctId, DoctorRequest doctorRequest) throws ResourceNotFoundException{
        Optional<Doctor> doctor = doctorRepository.findById(doctId);
        if (doctor.isEmpty()){
            throw new ResourceNotFoundException("Doctor", "doctorId", doctId);
        } else {
            doctor.get().setEmployee_id(doctorRequest.getEmployee_id());
            doctor.get().setDepartment(doctorRequest.getDepartment());
            doctor.get().setName(doctorRequest.getName());

            doctor.get().setPatientList(doctorRequest.getPatientList());
            doctor.get().setStatus(doctorRequest.getStatus());
            doctorRepository.save(doctor.get());
        }
        return doctor;
    }

    @Override
    public void deleteDoctor(Integer doctId) throws ResourceNotFoundException{
        if (Objects.equals(doctorRepository.getById(doctId).getDoctorId(), doctId)){
            doctorRepository.deleteById(doctId);
        }else {
            throw new ResourceNotFoundException("Doctor", "doctorId", doctId);
        }
    }
    @Override
    public Doctor getASingleDoctor(Integer doctId) throws ResourceNotFoundException{
        return doctorRepository.findById(doctId).orElseThrow(() -> new ResourceNotFoundException("Doctor", "doctorId", doctId));
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }


}
