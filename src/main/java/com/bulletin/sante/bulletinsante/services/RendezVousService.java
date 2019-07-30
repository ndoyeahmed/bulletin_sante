package com.bulletin.sante.bulletinsante.services;

import com.bulletin.sante.bulletinsante.models.RendezVous;
import com.bulletin.sante.bulletinsante.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RendezVousService {

    @Autowired
    private RendezVousRepository rendezVousRepository;

    public List<RendezVous> allRendezVous() {
        try {
            return rendezVousRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean addRendezVous(RendezVous rendezVous) {
        try {
            if (rendezVous.getDateRendezVous() != null && rendezVous.getPatient() != null) {
                rendezVousRepository.save(rendezVous);
                return true;
            } else return false;
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
