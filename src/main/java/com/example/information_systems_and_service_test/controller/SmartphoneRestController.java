package com.example.information_systems_and_service_test.controller;

import com.example.information_systems_and_service_test.entity.Model;
import com.example.information_systems_and_service_test.entity.Smartphone;
import com.example.information_systems_and_service_test.service.SmartphoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("equipment-register-api/model/smartphone")
public class SmartphoneRestController {
    private final SmartphoneService smartphoneService;

    @GetMapping("/search-filter")
    public List<Smartphone> getSmartphoneSearch(@RequestParam(value = "memory", required = false) String memory,
                                                @RequestParam(value = "cameraCount", required = false) Integer cameraCount) {
        return this.smartphoneService.getSmartphoneFilterList(memory, cameraCount);
    }

    @GetMapping("/{smartphoneId:d++}")
    public Smartphone getSmartphoneId(@PathVariable(value = "smartphoneId") int smartphoneId) {
        return this.smartphoneService.getSmartphoneId(smartphoneId);
    }
}
