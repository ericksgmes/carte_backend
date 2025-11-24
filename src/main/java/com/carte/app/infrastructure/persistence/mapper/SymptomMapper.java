package com.carte.app.infrastructure.persistence.mapper;


import com.carte.app.infrastructure.persistence.entity.SymptomEntity;
import com.carte.app.infrastructure.persistence.repository.dto.SymptomDto;

public final class SymptomMapper {

    private SymptomMapper() {
    }

    public static SymptomDto toDto(SymptomEntity entity) {
        if (entity == null) return null;
        return new SymptomDto(
                entity.getId(),
                entity.getUser().getId(),
                entity.getDescription(),
                entity.getDate()
        );
    }
}
