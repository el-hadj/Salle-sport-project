package com.tp.salledesport.heartratesensorworker.consumer;

import com.tp.salledesport.heartratesensorworker.config.MessageConfig;
import com.tp.salledesport.heartratesensorworker.dto.CustomMessage;
import com.tp.salledesport.heartratesensorworker.dto.HeartRateUser;
import com.tp.salledesport.heartratesensorworker.repository.HeartRateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class HeartRateWorkerConsumer {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private HeartRateRepository heartRateRepository;


    @RabbitListener(queues = MessageConfig.QUEUE)
    public HeartRateUser hearRateListener(CustomMessage customMessage) {

        log.info(" Receiving information from this queue with messageId {}", customMessage.getIdMessage());

        HeartRateUser heartRateUser = new HeartRateUser();
        heartRateUser.setUserId(customMessage.getUserId());
        heartRateUser.setId(customMessage.getIdHeartUser());
        heartRateUser.setAge(customMessage.getAge());
        heartRateUser.setHeartRateNow(customMessage.getHeartRateNow());

        log.info("this user heart rate {} information has been successfully saved", heartRateUser.getUserId());
        return heartRateRepository.insert(heartRateUser);
    }
}
