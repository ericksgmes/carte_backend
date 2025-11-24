package com.carte.app.infrastructure.persistence.repository;

import com.carte.app.infrastructure.persistence.entity.SymptomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSymptomRepository extends JpaRepository<SymptomEntity, Long> {
}