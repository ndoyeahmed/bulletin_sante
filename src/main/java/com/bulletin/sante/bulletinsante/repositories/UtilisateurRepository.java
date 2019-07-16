package com.bulletin.sante.bulletinsante.repositories;

import com.bulletin.sante.bulletinsante.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> getUtilisateurByEmailAndPassword(String email, String password);

    Optional<Utilisateur> getUtilisateurByEmail(String email);
}
