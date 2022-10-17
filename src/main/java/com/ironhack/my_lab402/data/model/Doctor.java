package com.ironhack.my_lab402.data.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "doctor")
@EntityListeners(AuditingEntityListener.class)
public class Doctor {
    @Id
    @Column(name = "employee_id", nullable = false)
    private long employeeId;
    @Column(name = "department", nullable = false)
    private String department;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany
    private List<Patient> patientList;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DoctorStatus status;

    public Doctor() {
    }

    public Doctor(long employee_id, String department, String name, List<Patient> patientList, DoctorStatus status) {
        this.employeeId = employee_id;
        this.department = department;
        this.name = name;
        this.patientList = patientList;
        this.status = status;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public DoctorStatus getStatus() {
        return status;
    }

    public void setStatus(DoctorStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return getEmployeeId() == doctor.getEmployeeId() && getDepartment().equals(doctor.getDepartment()) && getName().equals(doctor.getName()) && getPatientList().equals(doctor.getPatientList()) && getStatus() == doctor.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getDepartment(), getName(), getPatientList(), getStatus());
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "employee_id=" + employeeId +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", patientList=" + patientList +
                ", status=" + status +
                '}';
    }
}
