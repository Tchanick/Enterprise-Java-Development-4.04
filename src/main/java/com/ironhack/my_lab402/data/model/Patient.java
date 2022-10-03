package com.ironhack.my_lab402.data.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "patient")
@EntityListeners(AuditingEntityListener.class)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patient_id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "date_of_birth", nullable = false)
    private Date date_of_birth;
    @Column(name = "admitted_by", nullable = false)
    private long admitted_by;

    public Patient(String name, Date date_of_birth, long admitted_by) {
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.admitted_by = admitted_by;
    }

    public Patient() {

    }

    public int getPatient_id() {
        return patient_id;
    }

    public String getName() {
        return name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public long getAdmitted_by() {
        return admitted_by;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setAdmitted_by(long admitted_by) {
        this.admitted_by = admitted_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return getPatient_id() == patient.getPatient_id() && getAdmitted_by() == patient.getAdmitted_by() && getName().equals(patient.getName()) && getDate_of_birth().equals(patient.getDate_of_birth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPatient_id(), getName(), getDate_of_birth(), getAdmitted_by());
    }

    @Override
    public String toString() {
        return "patient{" +
                "patient_id=" + patient_id +
                ", name='" + name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", admitted_by=" + admitted_by +
                '}';
    }
}
