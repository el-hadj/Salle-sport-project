package com.tp.salledesport.heartratesensorcollector.publisher;

import com.tp.salledesport.heartratesensorcollector.config.MessageConfig;
import com.tp.salledesport.heartratesensorcollector.dto.CustomMessage;
import com.tp.salledesport.heartratesensorcollector.dto.UserProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
public class HeartRateSensorDataCollectorPublisher {


    @Autowired
    private RabbitTemplate template;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public HeartRateSensorDataCollectorPublisher(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping("/publish/{userId}")
    public String hearRateCollectData(@RequestBody Map<String,String> body, @PathVariable Integer userId){
        CustomMessage message = new CustomMessage();

        final UserProfile objectUser = restTemplate.getForObject("http://localhost:8081/api/v1/userprofile/"+ userId, UserProfile.class);


        message.setIdMessage(UUID.randomUUID().toString());
        message.setIdHeartUser(Integer.valueOf(body.get("id")));
        message.setUserId(objectUser.getId());
        message.setAge(objectUser.getAge());
        message.setHeartRateNow(Float.valueOf(body.get("heartRateNow")));
        template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, message);

        log.info("show this object user {}", objectUser);
        return "Your heart Rate information has been uploaded with id:"+ message.getIdMessage();
    }
}
