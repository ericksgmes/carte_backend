package com.carte.app.domain.model;

import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;
    private String email;
    private String name;
    private List<Meal> meals;
    private List<Symptom> symptoms;

    public User(UUID id, String email, String name, List<Meal> meals, List<Symptom> symptoms) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.meals = meals;
        this.symptoms = symptoms;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }
}
