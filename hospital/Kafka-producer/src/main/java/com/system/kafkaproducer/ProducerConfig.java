package com.system.kafkaproducer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

   @Bean
    public NewTopic topic(){
        return new NewTopic("learning-kafka",5,(short)1);
    }
}
