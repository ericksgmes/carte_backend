package com.carte.app.infrastructure.persistence.repository;

import com.carte.app.infrastructure.persistence.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFoodRepository extends JpaRepository<FoodEntity, Long> {
}
