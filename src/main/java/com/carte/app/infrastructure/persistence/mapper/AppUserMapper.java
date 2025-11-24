package com.carte.app.infrastructure.persistence.mapper;

import com.carte.app.infrastructure.persistence.entity.AppUserEntity;
import com.carte.app.infrastructure.persistence.repository.dto.AppUserDto;

public final class AppUserMapper {

    private AppUserMapper() {
    }

    public static AppUserDto toDto(AppUserEntity entity) {
        if (entity == null) return null;
        return new AppUserDto(
                entity.getId(),
                entity.getEmail(),
                entity.getNome()
        );
    }
}

