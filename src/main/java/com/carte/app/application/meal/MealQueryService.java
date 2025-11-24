package com.carte.app.application.meal;

import com.carte.app.infrastructure.persistence.mapper.MealMapper;
import com.carte.app.infrastructure.persistence.repository.JpaMealRepository;
import com.carte.app.infrastructure.persistence.repository.dto.MealDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MealQueryService {

    private final JpaMealRepository repository;

    public MealQueryService(JpaMealRepository repository) {
        this.repository = repository;
    }

    public List<MealDto> getAll() {
        return repository.findAll()
                .stream()
                .map(MealMapper::toDto)
                .toList();
    }

    public MealDto getById(UUID id) {
        return repository.findById(id)
                .map(MealMapper::toDto)
                .orElse(null);
    }
}
