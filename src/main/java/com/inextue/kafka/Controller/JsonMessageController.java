package com.inextue.kafka.Controller;

import com.inextue.kafka.kafka.JsonKafkaProducer;
import com.inextue.kafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        System.out.println("This is user : "+user);
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("JSON Message send to the kafka topic");
    }
}
