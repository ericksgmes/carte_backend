package com.carte.app.infrastructure.persistence.mapper;

import com.carte.app.infrastructure.persistence.entity.MealEntity;
import com.carte.app.infrastructure.persistence.repository.dto.MealDto;

public final class MealMapper {

    private MealMapper() {
    }

    public static MealDto toDto(MealEntity entity) {
        if (entity == null) return null;
        return new MealDto(
                entity.getId(),
                entity.getUser().getId(),
                entity.getDate()
        );
    }
}
