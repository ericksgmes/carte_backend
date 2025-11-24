package com.carte.app.application.report;

import com.carte.app.domain.model.MealSymptomPair;
import com.carte.app.domain.model.MealSymptomReport;
import com.carte.app.infrastructure.persistence.entity.MealEntity;
import com.carte.app.infrastructure.persistence.entity.SymptomEntity;
import com.carte.app.infrastructure.persistence.repository.JpaMealRepository;
import com.carte.app.infrastructure.persistence.repository.JpaSymptomRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MealSymptomReportService {

    private final JpaMealRepository mealRepository;
    private final JpaSymptomRepository symptomRepository;

    public MealSymptomReportService(
            JpaMealRepository mealRepository,
            JpaSymptomRepository symptomRepository
    ) {
        this.mealRepository = mealRepository;
        this.symptomRepository = symptomRepository;
    }

    /**
     * Gera um report simples ligando refeições e sintomas de um usuário.
     *
     * Regras:
     * - considera apenas sintomas do mesmo usuário
     * - considera apenas sintomas que ocorreram DEPOIS da refeição
     * - e até windowHours horas após a refeição
     */
    public MealSymptomReport generateReportForUser(UUID userId, long windowHours) {
        List<MealEntity> meals = mealRepository.findAll().stream()
                .filter(m -> m.getUser().getId().equals(userId))
                .toList();

        List<SymptomEntity> symptoms = symptomRepository.findAll().stream()
                .filter(s -> s.getUser().getId().equals(userId))
                .toList();

        List<MealSymptomPair> pairs = buildPairs(meals, symptoms, windowHours);

        Map<String, Long> symptomFrequency = pairs.stream()
                .collect(Collectors.groupingBy(
                        MealSymptomPair::symptomDescription,
                        Collectors.counting()
                ));

        return new MealSymptomReport(userId, pairs, symptomFrequency);
    }

    private List<MealSymptomPair> buildPairs(
            List<MealEntity> meals,
            List<SymptomEntity> symptoms,
            long windowHours
    ) {
        return meals.stream()
                .flatMap(meal -> symptoms.stream()
                        .filter(symptom -> isWithinWindow(meal, symptom, windowHours))
                        .map(symptom -> new MealSymptomPair(
                                meal.getId(),
                                meal.getDate(),
                                symptom.getId(),
                                symptom.getDate(),
                                minutesBetween(meal, symptom),
                                symptom.getDescription()
                        ))
                )
                .toList();
    }

    private boolean isWithinWindow(
            MealEntity meal,
            SymptomEntity symptom,
            long windowHours
    ) {
        var mealDate = meal.getDate();
        var symptomDate = symptom.getDate();

        if (symptomDate.isBefore(mealDate)) {
            return false;
        }

        var diff = Duration.between(mealDate, symptomDate);
        return diff.toHours() <= windowHours;
    }

    private long minutesBetween(MealEntity meal, SymptomEntity symptom) {
        return Duration.between(meal.getDate(), symptom.getDate()).toMinutes();
    }
}
