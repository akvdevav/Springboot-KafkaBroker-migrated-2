package com.springbootkafka.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootkafka.model.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private final RabbitTemplate rabbitTemplate;

    public JsonMessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        // Send the User object as a message to the default exchange with a routing key that matches the queue name.
        rabbitTemplate.convertAndSend("user.queue", user);
        return ResponseEntity.ok(" Json message sent");
    }

}