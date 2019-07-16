package com.bulletin.sante.bulletinsante.services;

import com.bulletin.sante.bulletinsante.models.Utilisateur;
import com.bulletin.sante.bulletinsante.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional
public class UtilisateurService {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur login(String email, String password) {
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurByEmailAndPassword(email, password).orElse(null);
        if (utilisateur != null) {
            utilisateur.setConnected(true);
            utilisateurRepository.save(utilisateur);
            return utilisateur;
        } else return null;
    }

    public boolean addUser(Utilisateur utilisateur) {
        try {
           /* Utilisateur utilisateur = new Utilisateur();
            utilisateur.setEmail(utilisateurDTO.getEmail());
            utilisateur.setPassword(utilisateurDTO.getPassword());
            Profile profile = new Profile();
            profile.setId(utilisateurDTO.getProfile().getId());
            profile.setLibelle(utilisateurDTO.getProfile().getLibelle());
            utilisateur.setProfile(profile);
            utilisateur.setAdresse(utilisateurDTO.getAdresse());
            utilisateur.setNom(utilisateurDTO.getNom());
            utilisateur.setPrenom(utilisateurDTO.getPrenom());
            utilisateur.setTelephone(utilisateurDTO.getTelephone());
            Utilisateur utilisateur1 = utilisateurRepository.getUtilisateurByEmail(utilisateur.getEmail()).orElse(null);*/
            if (utilisateur != null) {
                utilisateur.setConnected(false);
                utilisateurRepository.save(utilisateur);
            } else return false;
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.INFO, e.getMessage());
            return false;
        }
    }

    public List<Utilisateur> allUser() {
        try {
            return utilisateurRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Utilisateur getUserById(Long id) {
        try {
            return utilisateurRepository.findById(id).orElse(null);
        } catch (Exception e) {
            LOGGER.log(Level.INFO, e.getMessage());
            return null;
        }
    }
}
