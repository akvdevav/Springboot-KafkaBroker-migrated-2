package com.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springbootkafka.model.User;

@Service
public class JsonKafkaProducer {
    @Value("${spring.kafka.topic_json.name}")
    private String queueName;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private final RabbitTemplate rabbitTemplate;

    public JsonKafkaProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(User data) {
        LOGGER.info(String.format("Message sent %s", data.toString()));
        rabbitTemplate.convertAndSend(queueName, data);
    }
}