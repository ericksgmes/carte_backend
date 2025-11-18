package com.carte.app.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "food")
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "food_allergen",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "allergen_id")
    )
    private List<AllergenEntity> allergens;

    public FoodEntity() {}

    public FoodEntity(String description, List<AllergenEntity> allergens) {
        this.description = description;
        this.allergens = allergens;
    }

    public List<AllergenEntity> getAllergens() {
        return allergens;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }
}
