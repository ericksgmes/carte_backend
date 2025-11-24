package com.carte.app.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "meal")
public class MealEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUserEntity user;

    @Column(name = "date", nullable = false)
    private OffsetDateTime date;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodEntity> food;

    protected MealEntity() {
        // JPA
    }

    public MealEntity(Long id, AppUserEntity user, OffsetDateTime date) {
        this.id = id;
        this.user = user;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public AppUserEntity getUser() {
        return user;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public List<FoodEntity> getFood() {
        return food;
    }

    public void setUser(AppUserEntity user) {
        this.user = user;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public void setFood(List<FoodEntity> food) {
        this.food = food;
    }
}
