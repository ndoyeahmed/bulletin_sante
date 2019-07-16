package com.bulletin.sante.bulletinsante.DTO;

import com.bulletin.sante.bulletinsante.models.RendezVous;
import com.bulletin.sante.bulletinsante.models.Utilisateur;

import java.io.Serializable;
import java.util.Date;

public class ConsultationDTO implements Serializable {
    private Long id;
    private String diagnostic;
    private Date dateConsultation;
    private RendezVous rendezVous;
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
}
