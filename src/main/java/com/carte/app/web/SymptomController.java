package com.carte.app.web;

import com.carte.app.application.symptom.SymptomQueryService;
import com.carte.app.infrastructure.persistence.repository.dto.SymptomDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/symptoms")
public class SymptomController {

    private final SymptomQueryService symptomQueryService;

    public SymptomController(SymptomQueryService symptomQueryService) {
        this.symptomQueryService = symptomQueryService;
    }

    @GetMapping
    public List<SymptomDto> getAll() {
        return symptomQueryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SymptomDto> getById(@PathVariable Long id) {
        SymptomDto symptom = symptomQueryService.getById(id);
        if (symptom == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(symptom);
    }
}
