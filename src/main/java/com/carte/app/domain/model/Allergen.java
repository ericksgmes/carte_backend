package com.carte.app.domain.model;

public class Allergen {
    private Long id;
    private String description;

    public Allergen(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public boolean affects(User user) {
        // TODO
        return true;
    }
}
