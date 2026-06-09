package com.ccmp.patient.event.payload;

import java.time.LocalDateTime;

public record PatientEnrolledEvent(
    String patientId,
    String email,
    LocalDateTime enrolledAt
) {}