package com.tp.salledesport.userprofile;


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

        });
    }
}
