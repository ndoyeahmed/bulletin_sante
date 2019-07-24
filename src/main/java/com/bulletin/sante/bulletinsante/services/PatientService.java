package com.bulletin.sante.bulletinsante.services;

import com.bulletin.sante.bulletinsante.DTO.PatientDTO;
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

    public boolean addOrUpdatePatient(PatientDTO patientDTO) {
        try {
            if (patientDTO != null && !patientDTO.getNom().equals("") && !patientDTO.getPrenom().equals("")
                    && !patientDTO.getTelephone().equals("")) {
                Patient patient = new Patient();
                if (patientDTO.getId() != null && patientDTO.getId() != 0)
                    patient.setId(patientDTO.getId());
                patient.setGenre(patientDTO.getGenre());
                patient.setAdresse(patientDTO.getAdresse());
                patient.setNom(patientDTO.getNom());
                patient.setPrenom(patientDTO.getPrenom());
                patient.setTelephone(patientDTO.getTelephone());
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
