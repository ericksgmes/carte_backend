package com.carte.app.infrastructure.persistence.repository.dto;

import java.util.UUID;

public record AppUserDto(
        UUID id,
        String email,
        String nome
) {
}

