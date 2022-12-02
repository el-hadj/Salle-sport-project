package com.tp.salledesport.heartratesensorworker.service;


import com.tp.salledesport.heartratesensorworker.dto.HeartRateUser;
import com.tp.salledesport.heartratesensorworker.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class HeartRateUserService {

    private HeartRateUser heartRateUser;

    public Integer calculateAge() {
        String yearOfbirth = heartRateUser.getYearOfBirth();
        LocalDate currentDate = LocalDate.parse(yearOfbirth);
        int yearOfBirthParse = currentDate.getYear();
        int age;
        age = 2022 - yearOfBirthParse;
        return age;
    }

    public Float calculateMaxHeartRate() {
        float rate;
        int age = calculateAge();
        rate = 220 - age;
        return rate;
    }

    public Float minTargetHeartRate() {
        float minHearRate;
        minHearRate = (float) (0.5 - calculateMaxHeartRate());
        return minHearRate;
    }

    public Float maxTargetHeartRate() {
        float maxHeartRate;
        maxHeartRate = (float) 0.85 - calculateMaxHeartRate();
        return maxHeartRate;
    }

    public Boolean SuscribingChecks(User user) {

        if (user.isSubscription()) {
            log.info("the user {} is well subscribe ", user.getUserName());
            return true;
        }
        log.info("the user {} is not subscribe ", user.getUserName());
        return false;
    }


}
