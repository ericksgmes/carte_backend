package com.carte.app.infrastructure.persistence.mapper;

import com.carte.app.infrastructure.persistence.entity.FoodEntity;
import com.carte.app.infrastructure.persistence.repository.dto.FoodDto;

public final class FoodMapper {

    private FoodMapper() {
    }

    public static FoodDto toDto(FoodEntity entity) {
        if (entity == null) return null;
        return new FoodDto(
                entity.getId(),
                entity.getMeal() != null ? entity.getMeal().getId() : null,
                entity.getDescription()
        );
    }
}
