package com.ccmp.patient.entity;

import com.ccmp.patient.converter.PiiEncryptorConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
     @Column(updatable = false, nullable = false)
    private String id; // FHIR Patient ID

    // PII - Automatically Encrypted in DB via our Converter
    @Convert(converter = PiiEncryptorConverter.class)
    @Column(nullable = false)
    private String firstName;

    @Convert(converter = PiiEncryptorConverter.class)
    @Column(nullable = false)
    private String lastName;

    @Convert(converter = PiiEncryptorConverter.class)
    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate birthDate;

    // Audit Fields (Crucial for HIPAA)
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}