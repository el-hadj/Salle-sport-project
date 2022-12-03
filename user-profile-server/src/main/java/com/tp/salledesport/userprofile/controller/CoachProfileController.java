package com.tp.salledesport.userprofile.controller;

import com.tp.salledesport.userprofile.model.CoachProfile;
import com.tp.salledesport.userprofile.model.UserProfile;
import com.tp.salledesport.userprofile.service.CoachProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/coachprofile")
public class CoachProfileController {

    private CoachProfileService coachProfileService;

    public CoachProfileController(CoachProfileService coachProfileService){
        this.coachProfileService = coachProfileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachProfile> getCoachById(@PathVariable Integer id){
        CoachProfile coachProfile = coachProfileService.findCoachById(id);
        log.info("user id find {}", coachProfile.getIdCoach());
        return new ResponseEntity<>(coachProfile, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CoachProfile> registerCoach (@RequestBody CoachProfile coachProfile){
        CoachProfile coachProfile1 = coachProfileService.addCoach(coachProfile);
        log.info("New user registration {}", coachProfile.getIdCoach());
        return new ResponseEntity<>(coachProfile1, HttpStatus.CREATED);
    }
}
