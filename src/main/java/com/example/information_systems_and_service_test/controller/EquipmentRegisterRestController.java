package com.example.information_systems_and_service_test.controller;

import com.example.information_systems_and_service_test.controller.data_creation.TechnicIntermediate;
import com.example.information_systems_and_service_test.entity.Technic;
import com.example.information_systems_and_service_test.service.TechnicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import jakarta.validation.Valid;

import java.awt.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("equipment-register-api/technic")
public class EquipmentRegisterRestController {
    private final TechnicService technicService;

    @GetMapping("/search-filter")
    public List<Technic> getTechnicSearch(@RequestParam(value = "name", required = false) String name,
                                          @RequestParam(value = "technicType", required = false) String technicType,
                                          @RequestParam(value = "color", required = false) String color,
                                          @RequestParam(value = "priceSortAsc", required = false) Boolean isPriceSortAsc) {
        return this.technicService.getTechnicSearchList(name, technicType, color, isPriceSortAsc);
    }

    @GetMapping("/price-sort")
    public List<Technic> getPriceSortAsc(@RequestParam("priceSortAsc") Boolean isPriceSortAsc) {
        return this.technicService.getPriceSort(isPriceSortAsc);
    }

    @GetMapping("/name-sort")
    public List<Technic> getNameSortAsc(@RequestParam("nameSortAsc") Boolean isNameSortAsc) {
        return this.technicService.getNameSort(isNameSortAsc);
    }

    @GetMapping("/{technicId:d++}")
    public Technic getTechnicId(@PathVariable(value = "technicId") int technicId) {
        return this.technicService.getTechnicId(technicId);
    }

    @PostMapping(value = "/create-technic", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTechnic(@Valid @RequestBody(required = false) TechnicIntermediate technicIntermediate) {
        this.technicService.createTechnic(technicIntermediate);
    }
}
