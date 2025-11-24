package com.carte.app.application.food;

import com.carte.app.infrastructure.persistence.mapper.FoodMapper;
import com.carte.app.infrastructure.persistence.repository.JpaFoodRepository;
import com.carte.app.infrastructure.persistence.repository.dto.FoodDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodQueryService {

    private final JpaFoodRepository repository;

    public FoodQueryService(JpaFoodRepository repository) {
        this.repository = repository;
    }

    public List<FoodDto> getAll() {
        return repository.findAll()
                .stream()
                .map(FoodMapper::toDto)
                .toList();
    }

    public FoodDto getById(Long id) {
        return repository.findById(id)
                .map(FoodMapper::toDto)
                .orElse(null);
    }
}
