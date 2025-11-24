package com.carte.app.domain.model;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public record MealSymptomReport(
        UUID userId,
        List<MealSymptomPair> pairs,
        Map<String, Long> symptomFrequency
) {
}
