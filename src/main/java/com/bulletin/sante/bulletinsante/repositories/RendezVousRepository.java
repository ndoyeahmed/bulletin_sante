package com.bulletin.sante.bulletinsante.repositories;

import com.bulletin.sante.bulletinsante.models.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    Optional<List<RendezVous>> getAllByPatient_Id(Long id);
}
