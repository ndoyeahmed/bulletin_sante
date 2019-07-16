package com.bulletin.sante.bulletinsante.repositories;

import com.bulletin.sante.bulletinsante.models.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}
