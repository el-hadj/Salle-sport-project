package com.tp.salledesport.heartratesensorworker.repository;

import com.tp.salledesport.heartratesensorworker.dto.HeartRateUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeartRateRepository extends MongoRepository<HeartRateUser, Integer> {

    Optional<HeartRateUser> findByUserId(Integer idUser);
    Optional<HeartRateUser> findById(Integer id);
}
