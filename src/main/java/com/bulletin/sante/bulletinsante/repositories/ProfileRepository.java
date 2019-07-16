package com.bulletin.sante.bulletinsante.repositories;

import com.bulletin.sante.bulletinsante.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
