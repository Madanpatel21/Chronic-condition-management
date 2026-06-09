package com.ccmp.patient.enums;

public enum ErrorCode {
    PATIENT_NOT_FOUND("PAT001"),
    INVALID_FHIR_ID("VAL001"),
    HIPAA_VIOLATION("SEC001"),
    KAFKA_ERROR("MSG001");

    private final String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}