package com.carte.app.web;

import com.carte.app.application.meal.MealQueryService;
import com.carte.app.infrastructure.persistence.repository.dto.MealDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    private final MealQueryService mealQueryService;

    public MealController(MealQueryService mealQueryService) {
        this.mealQueryService = mealQueryService;
    }

    @GetMapping
    public List<MealDto> getAll() {
        return mealQueryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealDto> getById(@PathVariable UUID id) {
        MealDto meal = mealQueryService.getById(id);
        if (meal == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(meal);
    }
}
