package com.example.information_systems_and_service_test.controller;

import com.example.information_systems_and_service_test.entity.Refrigerator;
import com.example.information_systems_and_service_test.entity.Refrigerator;
import com.example.information_systems_and_service_test.service.RefrigeratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("equipment-register-api/model/refrigerator")
public class RefrigeratorRestController {
    private final RefrigeratorService refrigeratorService;

    @GetMapping("/search-filter")
    public List<Refrigerator> getRefrigeratorSearch(@RequestParam(value = "doorsCount", required = false) Integer doorsCount,
                                                    @RequestParam(value = "compressorType", required = false) String compressorType) {
        return this.refrigeratorService.getRefrigeratorFilterList(doorsCount, compressorType);
    }

    @GetMapping("/{refrigeratorId:d++}")
    public Refrigerator getRefrigeratorId(@PathVariable(value = "refrigeratorId") int refrigeratorId) {
        return this.refrigeratorService.getRefrigeratorId(refrigeratorId);
    }
}
