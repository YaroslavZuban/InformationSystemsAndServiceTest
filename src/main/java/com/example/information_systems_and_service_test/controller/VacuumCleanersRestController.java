package com.example.information_systems_and_service_test.controller;

import com.example.information_systems_and_service_test.entity.Model;
import com.example.information_systems_and_service_test.entity.VacuumCleaner;
import com.example.information_systems_and_service_test.service.VacuumCleanerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("equipment-register-api/model/vacuum-cleaner")
public class VacuumCleanersRestController {
    private final VacuumCleanerService vacuumCleanerService;

    @GetMapping("/search-filter")
    public List<VacuumCleaner> getVacuumCleanerSearch(@RequestParam(value = "dustCollectorCapacity", required = false) Integer dustCollectorCapacity,
                                        @RequestParam(value = "modeCount", required = false) Integer modeCount) {
        return this.vacuumCleanerService.getVacuumCleanerFilterList(dustCollectorCapacity,modeCount);
    }

    @GetMapping("/{vacuumCleanerId:d++}")
    public VacuumCleaner getVacuumCleanerId(@PathVariable(value = "vacuumCleanerId") int vacuumCleanerId) {
        return this.vacuumCleanerService.getVacuumCleanerId(vacuumCleanerId);
    }
}
