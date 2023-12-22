package com.quanmx.redispubsub.subscriber;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

public class MessageSubscriber implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("Chanel: " + new String(message.getChannel()) + ", body: " + new String(message.getBody()));
    }
}
