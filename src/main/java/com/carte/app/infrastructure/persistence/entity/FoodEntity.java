package com.carte.app.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "food")
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "meal_id", nullable = false)
    private MealEntity meal;

    @Column(nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "food_allergen",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "allergen_id")
    )
    private List<AllergenEntity> allergens;

    protected FoodEntity() {
        // JPA
    }

    public FoodEntity(MealEntity meal, String description) {
        this.meal = meal;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public MealEntity getMeal() {
        return meal;
    }

    public String getDescription() {
        return description;
    }

    public List<AllergenEntity> getAllergens() {
        return allergens;
    }

    public void setMeal(MealEntity meal) {
        this.meal = meal;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAllergens(List<AllergenEntity> allergens) {
        this.allergens = allergens;
    }
}

