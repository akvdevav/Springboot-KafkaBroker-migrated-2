package com.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @RabbitListener(queuesToDeclare = @Queue(name = "${spring.kafka.topic.name}"))
    public void consume(String message){
        LOGGER.info(String.format("Message received %s",message));
    }
}