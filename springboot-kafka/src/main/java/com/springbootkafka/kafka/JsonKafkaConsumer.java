package com.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.Queue;

import com.springbootkafka.model.User;

@Service
public class JsonKafkaConsumer
{
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @RabbitListener(queuesToDeclare = @Queue(name = "${spring.kafka.topic_json.name}"))
    public void consume(User user){
        LOGGER.info(String.format("Consumed message %s",user.toString()));
    }
}