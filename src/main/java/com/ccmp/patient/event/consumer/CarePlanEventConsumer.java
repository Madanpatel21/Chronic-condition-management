package com.ccmp.patient.event.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CarePlanEventConsumer {

    @KafkaListener(topics = "careplan-events", groupId = "patient-service")
    public void handleCarePlanEvent(ConsumerRecord<String, String> record) {
        log.info("Received careplan event: key={}, value={}", record.key(), record.value());
    }
}