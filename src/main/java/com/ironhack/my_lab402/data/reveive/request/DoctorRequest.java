package com.ironhack.my_lab402.data.reveive.request;

import com.ironhack.my_lab402.data.model.DoctorStatus;
import com.ironhack.my_lab402.data.model.Patient;
import com.sun.istack.NotNull;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class DoctorRequest {
    @NotBlank
    @NotNull
    private long employee_id;
    @NotBlank
    @NotNull
    private String department;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private List<Patient> patientList;
    @NotBlank
    @NotNull
    @Enumerated(EnumType.STRING)
    private DoctorStatus status;

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoctorStatus getStatus() {
        return status;
    }

    public void setStatus(DoctorStatus status) {
        this.status = status;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}
