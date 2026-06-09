package com.ccmp.patient.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

public record PatientRequestDTO(
    @NotBlank(message = "First name is required")
    String firstName,

    @NotBlank(message = "Last name is required")
    String lastName,

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    String email,

    @Past(message = "Birth date must be in the past")
    LocalDate birthDate
) {}