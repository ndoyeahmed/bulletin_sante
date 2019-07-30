package com.bulletin.sante.bulletinsante.services;

import com.bulletin.sante.bulletinsante.models.Consultation;
import com.bulletin.sante.bulletinsante.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ConsultationService {
    @Autowired
    private ConsultationRepository consultationRepository;


    public List<Consultation> allConsultation() {
        try {
            return consultationRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean addConsultation(Consultation consultation) {
        try {
            if (!consultation.getDiagnostic().equals("") && consultation.getRendezVous() != null
                    && consultation.getUtilisateur() != null) {
                consultation.setDateConsultation(Timestamp.valueOf(LocalDateTime.now()));
                consultationRepository.save(consultation);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Consultation getConsultationById(Long id) {
        try {
            return consultationRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
