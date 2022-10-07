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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int doctorId;
    @Column(name = "employee_id", nullable = false)
    private long employee_id;
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
        this.employee_id = employee_id;
        this.department = department;
        this.name = name;
        this.patientList = patientList;
        this.status = status;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public DoctorStatus getStatus() {
        return status;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public void setStatus(DoctorStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return getDoctorId() == doctor.getDoctorId() && getEmployee_id() == doctor.getEmployee_id() && getDepartment().equals(doctor.getDepartment()) && getName().equals(doctor.getName()) && getPatientList().equals(doctor.getPatientList()) && getStatus() == doctor.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoctorId(), getEmployee_id(), getDepartment(), getName(), getPatientList(), getStatus());
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", employee_id=" + employee_id +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", patientList=" + patientList +
                ", status=" + status +
                '}';
    }
}
