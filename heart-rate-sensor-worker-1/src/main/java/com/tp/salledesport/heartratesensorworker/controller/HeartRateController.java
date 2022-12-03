package com.tp.salledesport.heartratesensorworker.controller;

import com.tp.salledesport.heartratesensorworker.dto.HeartRateUser;
import com.tp.salledesport.heartratesensorworker.dto.User;
import com.tp.salledesport.heartratesensorworker.service.HeartRateUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/api/v1/heartworker")
public class HeartRateController {

    private HeartRateUserService heartRateUserService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public HeartRateController(HeartRateUserService heartRateUserService) {
        this.heartRateUserService = heartRateUserService;
    }



    @GetMapping("/checkSucription/{idUser}")
    public Boolean checkUserSuscription(@PathVariable Integer idUser){
        final User user = restTemplate.getForObject("http://localhost:8081/api/v1/userprofile/"+ idUser,User.class);
        if (user.isSubscription()) {
            log.info("the user {} is well subscribe ", user.getUserName());
            return true;
        }
        log.info("the user {} is not subscribe ", user.getUserName());
        return false;
    }

    @GetMapping("/emergencyChecks/{idUser}")
    public Boolean EmergencyChecks(@PathVariable Integer idUser){
        final User user = restTemplate.getForObject("http://localhost:8081/api/v1/userprofile/"+ idUser,User.class);
        HeartRateUser heartRateUser = new HeartRateUser();
        heartRateUser.setUserId(user.getId());
        heartRateUser.setAge(user.getAge());
        return heartRateUserService.emergencyChecks(heartRateUser.getUserId());

    }

}
