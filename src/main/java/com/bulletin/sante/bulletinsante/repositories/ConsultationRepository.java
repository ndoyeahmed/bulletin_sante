package com.bulletin.sante.bulletinsante.repositories;

import com.bulletin.sante.bulletinsante.models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
