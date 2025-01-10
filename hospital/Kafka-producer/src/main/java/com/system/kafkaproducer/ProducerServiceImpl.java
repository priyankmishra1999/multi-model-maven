package com.system.kafkaproducer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProducerServiceImpl<T> implements ProducerService<T> {

    private static final Logger log = LoggerFactory.getLogger(ProducerServiceImpl.class);
    private final KafkaTemplate<String, T> template;

    public ProducerServiceImpl(KafkaTemplate<String, T> template) {
        this.template = template;
    }

    @Override
    @Async("AsyncExecutor")
    public void sendDataToKafka(String topic, T message) {
        try {
            template.send(topic, message);
        } catch (Exception e) {
            log.error("Error in sending the data to the kafka: {}", e.getMessage());
        }
    }
}
