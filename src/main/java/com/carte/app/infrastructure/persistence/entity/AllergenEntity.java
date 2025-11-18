package com.carte.app.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "allergen")
public class AllergenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;

    public AllergenEntity() {}

    public AllergenEntity(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }
}
