package com.ccmp.patient.validation;

import com.ccmp.patient.validation.impl.FhirIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FhirIdValidator.class)
public @interface ValidFhirId {
    String message() default "Invalid FHIR ID format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}