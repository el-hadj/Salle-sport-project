package com.tp.salledesport.userprofile.service;


import com.tp.salledesport.userprofile.model.Gender;
import com.tp.salledesport.userprofile.model.TrainingProfile;
import com.tp.salledesport.userprofile.model.UserProfile;
import com.tp.salledesport.userprofile.repository.UserProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile addUser(UserProfile userProfile){
        userProfile.setSex(Gender.Men);
        userProfile.setTrainingProfile(TrainingProfile.Basic);
        return userProfileRepository.save(userProfile);
    }

    public UserProfile findUserById(Integer id){
        return userProfileRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("User id " + id + " was not found")
        );
    }
}
