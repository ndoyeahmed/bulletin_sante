package com.bulletin.sante.bulletinsante.services;

import com.bulletin.sante.bulletinsante.DTO.ConsultationDTO;
import com.bulletin.sante.bulletinsante.models.Consultation;
import com.bulletin.sante.bulletinsante.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public boolean addConsultation(ConsultationDTO consultationDTO) {
        try {
            if (consultationDTO != null && !consultationDTO.getDiagnostic().equals("")
                    && consultationDTO.getDateConsultation() != null && consultationDTO.getRendezVous() != null
                    && consultationDTO.getUtilisateur() != null) {
                Consultation consultation = new Consultation();
                if (consultationDTO.getId() != null && consultationDTO.getId() != 0)
                    consultation.setId(consultationDTO.getId());
                consultation.setDateConsultation(consultationDTO.getDateConsultation());
                consultation.setDiagnostic(consultationDTO.getDiagnostic());
                consultation.setUtilisateur(consultationDTO.getUtilisateur());
                consultation.setRendezVous(consultationDTO.getRendezVous());
                consultationRepository.save(consultation);
                return true;
            } else return false;
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
