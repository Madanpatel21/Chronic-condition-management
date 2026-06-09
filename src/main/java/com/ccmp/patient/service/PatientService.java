package com.ccmp.patient.service;

import com.ccmp.patient.dto.PatientResponseDTO;
import com.ccmp.patient.dto.request.PatientRequestDTO;

public interface PatientService {

    PatientResponseDTO enrollPatient(PatientRequestDTO requestDTO);

    PatientResponseDTO getPatientById(String id);

    void deletePatient(String id);
}