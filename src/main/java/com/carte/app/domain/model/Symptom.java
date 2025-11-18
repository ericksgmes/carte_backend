package com.carte.app.domain.model;

import java.util.Date;

public class Symptom {
    private Long id;
    private String description;
    private Date date;

    public Symptom(Long id, Date date, String description) {
        this.id = id;
        this.date = date;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }
    public boolean happenedBetween(Date start, Date end) {
        return !date.before(start) && !date.after(end);
    }
}
