package com.carte.app.domain.model;

import java.time.OffsetDateTime;

public record MealSymptomPair(
        long mealId,
        OffsetDateTime mealDate,
        long symptomId,
        OffsetDateTime symptomDate,
        long minutesBetween,
        String symptomDescription
) {
}
