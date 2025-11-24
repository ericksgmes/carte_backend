package com.carte.app.web;

import com.carte.app.application.report.MealSymptomReportService;
import com.carte.app.domain.model.MealSymptomReport;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final MealSymptomReportService reportService;

    public ReportController(MealSymptomReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/users/{userId}")
    public MealSymptomReport getUserReport(
            @PathVariable UUID userId,
            @RequestParam(defaultValue = "8") long windowHours
    ) {
        return reportService.generateReportForUser(userId, windowHours);
    }
}

