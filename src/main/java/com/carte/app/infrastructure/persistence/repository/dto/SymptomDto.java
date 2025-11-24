package com.carte.app.infrastructure.persistence.repository.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record SymptomDto(
        Long id,
        UUID userId,
        String description,
        OffsetDateTime date
) {
}
