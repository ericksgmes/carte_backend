package com.carte.app.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "symptom")
public class SymptomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUserEntity user;

    @Column(nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private OffsetDateTime date;

    protected SymptomEntity() {
        // JPA
    }

    public SymptomEntity(AppUserEntity user, String description, OffsetDateTime date) {
        this.user = user;
        this.description = description;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public AppUserEntity getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setUser(AppUserEntity user) {
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }
}
