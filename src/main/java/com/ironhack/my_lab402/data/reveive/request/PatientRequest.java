package com.ironhack.my_lab402.data.reveive.request;

import com.ironhack.my_lab402.data.model.Doctor;
import com.sun.istack.NotNull;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class PatientRequest {
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private LocalDate date_of_birth;
    private Doctor doctor;
    @NotBlank
    @NotNull
    private long admitted_by;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public long getAdmitted_by() {
        return admitted_by;
    }

    public void setAdmitted_by(long admitted_by) {
        this.admitted_by = admitted_by;
    }
}
