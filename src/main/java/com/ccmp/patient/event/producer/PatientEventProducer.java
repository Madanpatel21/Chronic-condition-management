package com.ccmp.patient.event.producer;

import com.ccmp.patient.event.payload.PatientEnrolledEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientEventProducer {

    private final KafkaTemplate<String, PatientEnrolledEvent> kafkaTemplate;

    public void publishPatientEnrolled(PatientEnrolledEvent event) {
        log.info("Publishing PatientEnrollment for patientId: {}", event.patientId());
        
        kafkaTemplate.send("patient-enrolled-topic", event.patientId(), event);
    }
}