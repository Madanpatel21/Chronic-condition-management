package com.ccmp.patient.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PatientResponseDTO(
    String id,
    String firstName,
    String lastName,
    String email,
    LocalDate birthDate,
    LocalDateTime createdAt
) {}