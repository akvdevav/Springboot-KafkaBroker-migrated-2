package com.springbootkafka.kafka;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class KafkaProducer {
    @Value("${spring.kafka.topic.name}")
    private String topicName;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public KafkaProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("#### -> Producing message -> %s", message));
        rabbitTemplate.convertAndSend(topicName, message);
    }
}