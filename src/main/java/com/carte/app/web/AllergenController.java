package com.carte.app.web;

import com.carte.app.application.allergen.FindAllergenService;
import com.carte.app.domain.model.Allergen;
import com.carte.app.infrastructure.persistence.repository.AllergenDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/allergens")
public class AllergenController {
    private final FindAllergenService findAllergenService;

    public AllergenController(FindAllergenService findAllergenService) {
        this.findAllergenService = findAllergenService;
    }

    @GetMapping
    public ResponseEntity<List<AllergenDto>> findAllAllergens() {
        List<AllergenDto> result = findAllergenService.findAll();
        return ResponseEntity.ok(result);
    }
}
