package com.carte.app.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "app_user")
public class AppUserEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String nome;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MealEntity> meals;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SymptomEntity> symptoms;

    protected AppUserEntity() {
        // JPA
    }

    public AppUserEntity(UUID id, String email, String nome) {
        this.id = id;
        this.email = email;
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public List<MealEntity> getMeals() {
        return meals;
    }

    public List<SymptomEntity> getSymptoms() {
        return symptoms;
    }

    public void setMeals(List<MealEntity> meals) {
        this.meals = meals;
    }

    public void setSymptoms(List<SymptomEntity> symptoms) {
        this.symptoms = symptoms;
    }
}
