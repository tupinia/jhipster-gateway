package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.JhipsterGatewayKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jhipster-gateway-kafka")
public class JhipsterGatewayKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterGatewayKafkaResource.class);

    private JhipsterGatewayKafkaProducer kafkaProducer;

    public JhipsterGatewayKafkaResource(JhipsterGatewayKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
