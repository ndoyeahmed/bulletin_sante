package com.bulletin.sante.bulletinsante.repositories;

import com.bulletin.sante.bulletinsante.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
