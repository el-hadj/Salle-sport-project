package com.tp.salledesport.heartratesensorworker.repository;

import com.tp.salledesport.heartratesensorworker.dto.Emergency;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyRepository extends MongoRepository<Emergency, Integer> {
}
