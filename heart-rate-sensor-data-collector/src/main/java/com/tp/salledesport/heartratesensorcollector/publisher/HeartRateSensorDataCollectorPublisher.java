package com.tp.salledesport.heartratesensorcollector.publisher;

import com.tp.salledesport.heartratesensorcollector.config.MessageConfig;
import com.tp.salledesport.heartratesensorcollector.dto.CustomMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class HeartRateSensorDataCollectorPublisher {



    private RabbitTemplate template;

    @Autowired
    public HeartRateSensorDataCollectorPublisher(RabbitTemplate template) {
        this.template = template;
    }

    @RequestMapping(value ="/publish", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String hearRateCollectData(@RequestBody Map<String,String> body){
        CustomMessage message = new CustomMessage();

        message.setIdMessage(UUID.randomUUID().toString());
        message.setIdHeartUser(Integer.valueOf(body.get("id")));
        message.setUserId(Integer.valueOf(body.get("userId")));
        message.setAge(Integer.valueOf(body.get("age")));
        message.setHeartRateNow(Float.valueOf(body.get("heartRateNow")));
        template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, message);


        return "Your heart Rate information has been uploaded with id:"+ message.getIdMessage();
    }
}
