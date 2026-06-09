package com.ccmp.patient.mapper;

import com.ccmp.patient.dto.PatientResponseDTO;
import com.ccmp.patient.dto.request.PatientRequestDTO;
import com.ccmp.patient.entity.Patient;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientMapper {

    public Patient toEntity(PatientRequestDTO dto);
    
    @Mapping(source = "id", target = "patientId")
    @Mapping(source = "createdAt", target = "enrolledAt")
    public PatientResponseDTO toDTO(Patient entity);

}
