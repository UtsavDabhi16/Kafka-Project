package com.inextue.kafka.Controller;


import com.inextue.kafka.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    @Autowired
    public KafkaProducer kafkaProducer;

        //http:localhost:8080/api/v1/kafka/publish?message=hello
    @GetMapping("/publish/{message}")
    public ResponseEntity<String> publish(@PathVariable("message") String message){
        System.out.println("This is msg : "+message);
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message send to the topic");
    }

}