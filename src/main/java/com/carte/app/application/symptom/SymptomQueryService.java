package com.carte.app.application.symptom;

import com.carte.app.infrastructure.persistence.mapper.SymptomMapper;
import com.carte.app.infrastructure.persistence.repository.JpaSymptomRepository;
import com.carte.app.infrastructure.persistence.repository.dto.SymptomDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomQueryService {

    private final JpaSymptomRepository repository;

    public SymptomQueryService(JpaSymptomRepository repository) {
        this.repository = repository;
    }

    public List<SymptomDto> getAll() {
        return repository.findAll()
                .stream()
                .map(SymptomMapper::toDto)
                .toList();
    }

    public SymptomDto getById(Long id) {
        return repository.findById(id)
                .map(SymptomMapper::toDto)
                .orElse(null);
    }
}
