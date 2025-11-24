package com.carte.app.web;

import com.carte.app.application.food.FoodQueryService;
import com.carte.app.infrastructure.persistence.repository.dto.FoodDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    private final FoodQueryService foodQueryService;

    public FoodController(FoodQueryService foodQueryService) {
        this.foodQueryService = foodQueryService;
    }

    @GetMapping
    public List<FoodDto> getAll() {
        return foodQueryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDto> getById(@PathVariable Long id) {
        FoodDto food = foodQueryService.getById(id);
        if (food == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(food);
    }
}
