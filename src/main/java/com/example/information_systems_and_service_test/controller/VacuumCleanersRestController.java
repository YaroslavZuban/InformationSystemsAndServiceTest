package com.example.information_systems_and_service_test.controller;

import com.example.information_systems_and_service_test.entity.Model;
import com.example.information_systems_and_service_test.entity.VacuumCleaner;
import com.example.information_systems_and_service_test.service.VacuumCleanerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("equipment-register-api/model/vacuum-cleaner")
public class VacuumCleanersRestController {
    private final VacuumCleanerService vacuumCleanerService;

    @GetMapping("/search-filter")
    public ResponseEntity<?> getVacuumCleanerSearch(@RequestParam(value = "dustCollectorCapacity", required = false) Integer dustCollectorCapacity,
                                                 @RequestParam(value = "modeCount", required = false) Integer modeCount) {
        return ResponseEntity.ok().body(this.vacuumCleanerService.getVacuumCleanerFilterList(dustCollectorCapacity,modeCount));
    }

    @GetMapping("/{vacuumCleanerId:\\d}")
    public ResponseEntity<?> getVacuumCleanerId(@PathVariable(value = "vacuumCleanerId") int vacuumCleanerId) {
        return ResponseEntity.ok().body(this.vacuumCleanerService.getVacuumCleanerId(vacuumCleanerId));
    }
}
