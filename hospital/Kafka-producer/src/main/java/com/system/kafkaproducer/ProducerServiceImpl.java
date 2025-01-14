package com.system.kafkaproducer;

import com.system.model.Doctor;
//import com.system.responseModel.KafkaModel;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.Future;

@Service
public class ProducerServiceImpl implements ProducerService {

    private static final Logger log = LoggerFactory.getLogger(ProducerServiceImpl.class);
    private final KafkaTemplate<String, Object> template;

    public ProducerServiceImpl(KafkaTemplate<String, Object> template) {
        this.template = template;
    }

    @Override
    @Async("AsyncExecutor")
    public void sendDataToKafka(String topic, Doctor message) {
        try {
             template.send(topic, message);
//            System.out.println(send.get());

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error in sending the data to the kafka: {}", e.getMessage());
        }
    }
}
