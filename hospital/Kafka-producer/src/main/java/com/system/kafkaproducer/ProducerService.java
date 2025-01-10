package com.system.kafkaproducer;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ProducerService<T> {
    void sendDataToKafka(String topic, T message);
}
