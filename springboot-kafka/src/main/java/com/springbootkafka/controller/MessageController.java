package com.springbootkafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private final RabbitTemplate rabbitTemplate;

    public MessageController(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message){
        rabbitTemplate.convertAndSend("myQueue", message);
        return ResponseEntity.ok("Message sent to the queue");
    }

}