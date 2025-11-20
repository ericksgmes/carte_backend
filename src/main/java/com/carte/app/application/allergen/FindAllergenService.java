package com.carte.app.application.allergen;

import com.carte.app.infrastructure.persistence.entity.AllergenEntity;
import com.carte.app.infrastructure.persistence.mapper.AllergenMapper;
import com.carte.app.infrastructure.persistence.repository.AllergenDto;
import com.carte.app.infrastructure.persistence.repository.JpaAllergenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindAllergenService{
    private final JpaAllergenRepository jpaAllergenRepository;
    public FindAllergenService(
            JpaAllergenRepository repository
    ) {
        this.jpaAllergenRepository = repository;
    }

    public List<AllergenDto> findAll() {
        List<AllergenEntity> allergens = jpaAllergenRepository.findAll();
        return allergens.stream().map(AllergenMapper::toAllergenDto).collect(Collectors.toList());
    }
}
