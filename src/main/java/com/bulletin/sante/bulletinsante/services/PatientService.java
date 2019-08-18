package com.bulletin.sante.bulletinsante.services;

import com.bulletin.sante.bulletinsante.models.Patient;
import com.bulletin.sante.bulletinsante.models.Utilisateur;
import com.bulletin.sante.bulletinsante.repositories.PatientRepository;
import com.bulletin.sante.bulletinsante.repositories.ProfileRepository;
import com.bulletin.sante.bulletinsante.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public boolean addOrUpdatePatient(Patient patient) {
        try {
            if (!patient.getAdresse().equals("") && !patient.getNom().equals("")
                    && !patient.getPrenom().equals("") && !patient.getTelephone().equals("")) {
                patient.setNomComplet(patient.getNom() + " " + patient.getPrenom());
                Utilisateur utilisateur = new Utilisateur();
                patientRepository.save(patient);
                utilisateur.setEmail(patient.getNom() + "." + patient.getPrenom() + "" + patient.getId() + "@mail.com");
                utilisateur.setPassword("passer@123");
                utilisateur.setPrenom(patient.getPrenom());
                utilisateur.setAdresse(patient.getAdresse());
                utilisateur.setTelephone(patient.getTelephone());
                utilisateur.setNom(patient.getNom());
                utilisateur.setNomComplet(patient.getNomComplet());
                utilisateur.setProfile(profileRepository.getByLibelle("Patient").orElseThrow(() -> new Exception("Profile not exist")));
                utilisateur.setConnected(false);
                utilisateurRepository.save(utilisateur);
                return true;
            } else return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Patient> allPatient() {
        try {
            return patientRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Patient getPatientById(Long id) {
        try {
            return patientRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
