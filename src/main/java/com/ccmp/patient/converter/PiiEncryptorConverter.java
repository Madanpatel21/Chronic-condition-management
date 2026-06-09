package com.ccmp.patient.converter;

import com.ccmp.patient.Security.AesEncryptorUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PiiEncryptorConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (attribute == null) return null;
        return AesEncryptorUtil.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return AesEncryptorUtil.decrypt(dbData);
    }
}