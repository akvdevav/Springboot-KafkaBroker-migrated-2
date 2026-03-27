package com.springbootkafka.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic_json.name}")
    private String jsonTopicName;

    @Bean
    public Queue topicQueue() {
        return new Queue(topicName, true);
    }

    @Bean
    public Queue jsonTopicQueue() {
        return new Queue(jsonTopicName, true);
    }
}