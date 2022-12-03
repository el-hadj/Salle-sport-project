package com.tp.salledesport.heartratesensorworker;

import com.tp.salledesport.heartratesensorworker.dto.HeartRateUser;
import com.tp.salledesport.heartratesensorworker.repository.HeartRateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HeartRateSensorWorkerApplication {
    public static void main(String[] args) {
            SpringApplication.run(HeartRateSensorWorkerApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
