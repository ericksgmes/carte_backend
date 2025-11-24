package com.carte.app.infrastructure.persistence.repository.dto;

public record FoodDto(
        Long id,
        Long mealId,
        String description
) {
}

