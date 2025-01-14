package com.system.kafkaconsumer;


import com.system.model.Doctor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {


    private static final Logger log = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "learning-kafka", groupId = "kafka-grp")
    @Async("AsyncExecutor")
    public void consume1(Doctor message) {
        log.info("Message for consumer1 is :- {}", message.toString());
    }

}
