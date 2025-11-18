package com.carte.app.infrastructure.persistence.repository;

import com.carte.app.infrastructure.persistence.entity.AllergenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAllergenRepository extends JpaRepository<AllergenEntity, Long> {}
