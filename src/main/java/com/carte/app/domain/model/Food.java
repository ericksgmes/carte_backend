package com.carte.app.domain.model;

import java.util.List;

public class Food {
    private Long id;
    private String description;
    private List<Allergen> allergens;

    public Food(Long id, List<Allergen> allergens, String description) {
        this.id = id;
        this.allergens = allergens;
        this.description = description;
    }

    @Override
    public String toString() {
        return "description: " + description + ", allergens: " + allergens;
    }

    public boolean containsAllergen(Allergen allergen) {
        return allergens.stream().anyMatch(a -> a.getId().equals(allergen.getId()));
    }
}
