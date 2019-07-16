package com.bulletin.sante.bulletinsante.DTO;

import com.bulletin.sante.bulletinsante.models.Patient;

import java.io.Serializable;
import java.util.Date;

public class RendezVousDTO implements Serializable {
    private Long id;
    private Date dateRendezVous;
    private Patient patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(Date dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
