package com.quanmx.redispubsub.controller;

import com.quanmx.redispubsub.publisher.RedisMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private RedisMessagePublisher publisher;

    @Autowired
    public MessageController(RedisMessagePublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/message")
    public void sendMessage(@RequestBody String message) {
        for (int i = 0; i < 1000; i++) {
            publisher.publish(message + i);
        }
    }
}
