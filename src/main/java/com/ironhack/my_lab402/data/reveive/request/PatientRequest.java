package com.ironhack.my_lab402.data.reveive.request;

import com.sun.istack.NotNull;

import javax.validation.constraints.*;
import java.util.Date;

public class PatientRequest {
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private Date date_of_birth;
    @NotBlank
    @NotNull
    private long admitted_by;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public long getAdmitted_by() {
        return admitted_by;
    }

    public void setAdmitted_by(long admitted_by) {
        this.admitted_by = admitted_by;
    }
}
