package com.company.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PositionNameConverter implements AttributeConverter<Position.Name, String> {
    public String convertToDatabaseColumn(Position.Name name) {
        if (name == null) {
            return null;
        }
        return name.getName();
    }

    @Override
    public Position.Name convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Position.Name.toEnum(dbData);
    }
}
