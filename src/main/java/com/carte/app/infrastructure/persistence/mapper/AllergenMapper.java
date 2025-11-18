package com.carte.app.infrastructure.persistence.mapper;

import com.carte.app.infrastructure.persistence.entity.AllergenEntity;
import com.carte.app.infrastructure.persistence.repository.AllergenDto;

public class AllergenMapper {
    public static AllergenEntity toAllergenEntity(AllergenDto allergenDto) {
        return new AllergenEntity(allergenDto.id(), allergenDto.description());
    }

    public static AllergenDto toAllergenDto(AllergenEntity allergen) {
        return new AllergenDto(allergen.getId(), allergen.getDescription());
    }
}
