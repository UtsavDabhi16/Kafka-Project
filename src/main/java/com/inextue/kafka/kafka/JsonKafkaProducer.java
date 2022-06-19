package com.inextue.kafka.kafka;

import com.inextue.kafka.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data){
        Message<User> message= MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC,"utsav").build();
        kafkaTemplate.send(message);
    }
}
