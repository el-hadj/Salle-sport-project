package com.tp.salledesport.userprofile.controller;

import com.tp.salledesport.userprofile.model.UserProfile;
import com.tp.salledesport.userprofile.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/v1/userprofile")
public class UserProfileController {

    private UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserById(@PathVariable Integer id){
        UserProfile userProfile = userProfileService.findUserById(id);
        log.info("user id find {}", userProfile.getId());
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserProfile> registerUser (@RequestBody UserProfile userProfile){
        UserProfile newUser = userProfileService.addUser(userProfile);
        log.info("New user registration {}", userProfile.getId());
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
