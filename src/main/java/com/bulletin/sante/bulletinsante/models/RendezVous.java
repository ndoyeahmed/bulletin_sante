package com.bulletin.sante.bulletinsante.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRendezVous;
    @ManyToOne
    @JoinColumn(name = "patient", referencedColumnName = "id")
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
