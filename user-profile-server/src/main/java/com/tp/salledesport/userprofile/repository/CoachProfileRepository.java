package com.tp.salledesport.userprofile.repository;

import com.tp.salledesport.userprofile.model.CoachProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachProfileRepository extends JpaRepository<CoachProfile, Integer> {
}
