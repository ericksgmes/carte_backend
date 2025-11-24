package com.carte.app.infrastructure.persistence.repository;

import com.carte.app.infrastructure.persistence.entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaAppUserRepository extends JpaRepository<AppUserEntity, UUID> {
}