package com.carte.app.domain.model;

import java.util.Date;
import java.util.List;

public class Meal {
    private Long id;
    private List<Food> food;
    private Date date;

    public Meal(List<Food> food, Long id, Date date) {
        this.food = food;
        this.id = id;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Meal{" + "id=" + id + ", food=" + food + ", date=" + date + '}';
    }

    public List<Food> getFood() {
        return food;
    }

    public Date getDate() {
        return date;
    }
}
