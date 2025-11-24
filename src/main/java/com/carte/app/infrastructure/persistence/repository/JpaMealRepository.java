package com.carte.app.infrastructure.persistence.repository;

import com.carte.app.infrastructure.persistence.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaMealRepository extends JpaRepository<MealEntity, UUID> {
}