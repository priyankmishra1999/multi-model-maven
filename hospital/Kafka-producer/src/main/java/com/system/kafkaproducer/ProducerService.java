package com.system.kafkaproducer;

import com.system.model.Doctor;
//import com.system.responseModel.KafkaModel;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ProducerService {
    void sendDataToKafka(String topic, Doctor message);
}
