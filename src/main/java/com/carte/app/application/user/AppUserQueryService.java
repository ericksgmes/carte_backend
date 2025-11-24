package com.carte.app.application.user;

import com.carte.app.infrastructure.persistence.mapper.AppUserMapper;
import com.carte.app.infrastructure.persistence.repository.JpaAppUserRepository;
import com.carte.app.infrastructure.persistence.repository.dto.AppUserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppUserQueryService {

    private final JpaAppUserRepository repository;

    public AppUserQueryService(JpaAppUserRepository repository) {
        this.repository = repository;
    }

    public List<AppUserDto> getAll() {
        return repository.findAll()
                .stream()
                .map(AppUserMapper::toDto)
                .toList();
    }

    public AppUserDto getById(UUID id) {
        return repository.findById(id)
                .map(AppUserMapper::toDto)
                .orElse(null);
    }
}

