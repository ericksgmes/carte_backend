package com.carte.app.infrastructure.persistence.repository.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record MealDto(
        Long id,
        UUID userId,
        OffsetDateTime date
) {
}


