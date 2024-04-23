package com.example.information_systems_and_service_test.controller;

import com.example.information_systems_and_service_test.entity.Model;
import com.example.information_systems_and_service_test.entity.Smartphone;
import com.example.information_systems_and_service_test.service.SmartphoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("equipment-register-api/model/smartphone")
public class SmartphoneRestController {
    private final SmartphoneService smartphoneService;

    @GetMapping("/search-filter")
    public ResponseEntity<?> getSmartphoneSearch(@RequestParam(value = "memory", required = false) String memory,
                                                 @RequestParam(value = "cameraCount", required = false) Integer cameraCount) {
        return ResponseEntity.ok().body(this.smartphoneService.getSmartphoneFilterList(memory, cameraCount));
    }

    @GetMapping("/{smartphoneId:\\d}")
    public ResponseEntity<?> getSmartphoneId(@PathVariable(value = "smartphoneId") int smartphoneId) {
        return ResponseEntity.ok().body(this.smartphoneService.getSmartphoneId(smartphoneId));
    }
}
