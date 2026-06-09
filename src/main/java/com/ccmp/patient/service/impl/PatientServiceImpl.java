package com.ccmp.patient.service.impl;

import com.ccmp.patient.dto.PatientResponseDTO;
import com.ccmp.patient.dto.request.PatientRequestDTO;
import com.ccmp.patient.entity.Patient;
import com.ccmp.patient.event.payload.PatientEnrolledEvent;
import com.ccmp.patient.event.producer.PatientEventProducer;
import com.ccmp.patient.Exception.PatientNotFoundException;
import com.ccmp.patient.mapper.PatientMapper;
import com.ccmp.patient.repository.PatientRepository;
import com.ccmp.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final PatientEventProducer patientEventProducer;

    @Transactional
    @Override
    public PatientResponseDTO enrollPatient(PatientRequestDTO dto) {
        log.info("Attempting to enroll patient with email: {}", dto.email());

        Patient patient = patientMapper.toEntity(dto);
        Patient savedPatient = patientRepository.save(patient);
        // Publish event to Kafka asynchronously
        PatientEnrolledEvent event = new PatientEnrolledEvent(
                savedPatient.getId(),
                savedPatient.getEmail(),
                savedPatient.getCreatedAt()
        );
        patientEventProducer.publishPatientEnrolled(event);

        return patientMapper.toDTO(savedPatient);
    }

    @Override
    @Transactional(readOnly = true)
    public PatientResponseDTO getPatientById(String id) {
         log.info("Fetching patient with id: {}", id);
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));
        return patientMapper.toDTO(patient);
    }

    @Override
    @Transactional
    public void deletePatient(String id) {
        if (!patientRepository.existsById(id)) {
            throw new PatientNotFoundException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }
}