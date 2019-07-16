package com.bulletin.sante.bulletinsante.services;

import com.bulletin.sante.bulletinsante.DTO.RendezVousDTO;
import com.bulletin.sante.bulletinsante.models.RendezVous;
import com.bulletin.sante.bulletinsante.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RendezVousService {

    private final RendezVousRepository rendezVousRepository;

    public RendezVousService(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    public List<RendezVous> allRendezVous() {
        try {
            return rendezVousRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean addRendezVous(RendezVousDTO rendezVousDTO) {
        try {
            if (rendezVousDTO.getDateRendezVous() != null && rendezVousDTO.getPatient() != null) {
                RendezVous rendezVous = new RendezVous();
                rendezVous.setDateRendezVous(rendezVousDTO.getDateRendezVous());
                rendezVous.setPatient(rendezVousDTO.getPatient());
                rendezVousRepository.save(rendezVous);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public RendezVous getRendezVousById(Long id) {
        try {
            return rendezVousRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
