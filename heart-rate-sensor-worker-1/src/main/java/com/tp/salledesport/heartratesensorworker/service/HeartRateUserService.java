package com.tp.salledesport.heartratesensorworker.service;


import com.tp.salledesport.heartratesensorworker.dto.HeartRateUser;
import com.tp.salledesport.heartratesensorworker.dto.User;
import com.tp.salledesport.heartratesensorworker.repository.HeartRateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class HeartRateUserService {


    private HeartRateUser heartRateUser;

    private HeartRateRepository heartRateRepository;

    private  User user;

    @Autowired
    public HeartRateUserService( HeartRateRepository heartRateRepository) {
        this.heartRateRepository = heartRateRepository;
    }

    public Float calculateMaxHeartRate(int age) {
        //La méthode la plus fiable que nous vous conseillons : FC max = 207 – 0,7 x âge
        float rate;
        rate = (float) (207 - 0.7 * age);
        return rate;
    }


    public boolean emergencyChecks(Integer idUser){
        HeartRateUser heartRateUser = heartRateRepository.findByUserId(idUser)
                .orElseThrow(
                        ()-> new RuntimeException("this idUser " + idUser + " does not exit")
                );
        Float heartRateNow = heartRateUser.getHeartRateNow();
        if(heartRateNow < calculateMaxHeartRate(heartRateUser.getAge())){
            log.info("the user  {} is having a heartrate trouble ", heartRateUser.getUserId());
            return true;
        }
         log.info("the user  {} is not having a heartrate trouble ", heartRateUser.getUserId());
        return false;
    }

}
