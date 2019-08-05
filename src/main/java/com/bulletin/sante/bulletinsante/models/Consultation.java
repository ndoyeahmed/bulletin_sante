package com.bulletin.sante.bulletinsante.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Consultation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diagnostic;
    private String prescription;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateConsultation;
    @ManyToOne
    @JoinColumn(name = "rendezVous", referencedColumnName = "id")
    private RendezVous rendezVous;
    @ManyToOne
    @JoinColumn(name = "utilisateur", referencedColumnName = "id")
    private Utilisateur utilisateur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public RendezVous getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(RendezVous rendezVous) {
        this.rendezVous = rendezVous;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}
