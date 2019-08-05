package com.bulletin.sante.bulletinsante.services;

import com.bulletin.sante.bulletinsante.models.Profile;
import com.bulletin.sante.bulletinsante.models.Utilisateur;
import com.bulletin.sante.bulletinsante.repositories.ProfileRepository;
import com.bulletin.sante.bulletinsante.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private ProfileRepository profileRepository;

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
            if (utilisateur != null && utilisateur.getId() != null && !utilisateur.getEmail().equals("")
                    && !utilisateur.getAdresse().equals("") && !utilisateur.getNom().equals("")
                    && !utilisateur.getPrenom().equals("") && !utilisateur.getTelephone().equals("")) {
                utilisateur.setConnected(false);
                utilisateur.setNomComplet(utilisateur.getNom() + " " + utilisateur.getPrenom());
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

    public boolean updateUser(Utilisateur utilisateur) {
        try {
            if (utilisateur != null && utilisateur.getId() != null) {
                utilisateurRepository.save(utilisateur);
                return true;
            } else return false;
        } catch (Exception e) {
            LOGGER.log(Level.INFO, e.getMessage());
            return false;
        }
    }

    public List<Profile> allProfile() {
        try {
            return profileRepository.findAll();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
