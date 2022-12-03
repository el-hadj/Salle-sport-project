package com.tp.salledesport.userprofile;


import com.tp.salledesport.userprofile.model.CoachProfile;
import com.tp.salledesport.userprofile.model.Gender;
import com.tp.salledesport.userprofile.model.TrainingProfile;
import com.tp.salledesport.userprofile.model.UserProfile;
import com.tp.salledesport.userprofile.repository.CoachProfileRepository;
import com.tp.salledesport.userprofile.repository.UserProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserProfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProfileApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CoachProfileRepository coachProfileRepository, UserProfileRepository userProfileRepository){
        return (args -> {
            CoachProfile coachProfile = new CoachProfile(1, "Dechamps", 1);
            UserProfile userProfile = new UserProfile(
                    1,"Elhadj", 70.2,23, Gender.Men,coachProfile.getIdCoach()
            );
            coachProfileRepository.save(coachProfile);
            userProfileRepository.save(userProfile);


        });
    }
}
