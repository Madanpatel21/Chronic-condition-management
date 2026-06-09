package com.ccmp.patient.dto.payload;

import java.time.LocalDateTime;

public record PatientEnrolledEvent(
    String patientId,
    String email,
    LocalDateTime enrolledAt
) {}