package com.tp.salledesport.heartratesensorcollector.publisher;

import com.tp.salledesport.heartratesensorcollector.config.ConfigHeartDataCollector;
import com.tp.salledesport.heartratesensorcollector.dto.CustomMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class HeartRateSensorDataCollectorPublisher {


    @Autowired
    private RabbitTemplate template;


    public HeartRateSensorDataCollectorPublisher(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping("/publish")
    public String publishMessage(@RequestBody CustomMessage message){
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(ConfigHeartDataCollector.EXCHANGE,
                ConfigHeartDataCollector.ROUTING_KEY, message);

        return "Your heart rate has been publish";
    }
}
