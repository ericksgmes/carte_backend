package com.carte.app.web;

import com.carte.app.application.user.AppUserQueryService;
import com.carte.app.infrastructure.persistence.repository.dto.AppUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private final AppUserQueryService appUserQueryService;

    public AppUserController(AppUserQueryService appUserQueryService) {
        this.appUserQueryService = appUserQueryService;
    }

    @GetMapping
    public List<AppUserDto> getAll() {
        return appUserQueryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserDto> getById(@PathVariable UUID id) {
        AppUserDto user = appUserQueryService.getById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
}
