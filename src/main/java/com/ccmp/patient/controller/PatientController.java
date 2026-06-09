package com.ccmp.patient.controller;

import com.ccmp.patient.dto.PatientResponseDTO;
import com.ccmp.patient.dto.request.PatientRequestDTO;
import com.ccmp.patient.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@Tag(name = "Patient API", description = "CRUD operations for CCM Patients")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    @Operation(summary = "Enroll a new patient into CCM")
    public ResponseEntity<PatientResponseDTO> createPatient(
    @Valid @RequestBody PatientRequestDTO requestDTO){
        PatientResponseDTO response = patientService.enrollPatient(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
        
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get patient by FHIR ID")
    public ResponseEntity<PatientResponseDTO> getPatient(@PathVariable String id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }
}