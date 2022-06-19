package com.inextue.kafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "utsav",groupId = "myGroup")
    public void consume(String message){
        System.out.println("Message received from : "+ message);
    }
}
