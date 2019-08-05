package com.bulletin.sante.bulletinsante.services;

import com.bulletin.sante.bulletinsante.models.Patient;
import com.bulletin.sante.bulletinsante.repositories.PatientRepository;
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

    public boolean addOrUpdatePatient(Patient patient) {
        try {
            if (!patient.getAdresse().equals("") && !patient.getNom().equals("")
                    && !patient.getPrenom().equals("") && !patient.getTelephone().equals("")) {
                patient.setNomComplet(patient.getNom() + " " + patient.getPrenom());
                patientRepository.save(patient);
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
