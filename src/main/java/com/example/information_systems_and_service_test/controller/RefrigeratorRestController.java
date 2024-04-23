package com.example.information_systems_and_service_test.controller;

import com.example.information_systems_and_service_test.entity.Refrigerator;
import com.example.information_systems_and_service_test.entity.Refrigerator;
import com.example.information_systems_and_service_test.service.RefrigeratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("equipment-register-api/model/refrigerator")
public class RefrigeratorRestController {
    private final RefrigeratorService refrigeratorService;

    @GetMapping("/search-filter")
    public ResponseEntity<?> getRefrigeratorSearch(@RequestParam(value = "doorsCount", required = false) Integer doorsCount,
                                                    @RequestParam(value = "compressorType", required = false) String compressorType) {
        return ResponseEntity.ok().body(this.refrigeratorService.getRefrigeratorFilterList(doorsCount, compressorType));
    }

    @GetMapping("/{refrigeratorId:\\d}")
    public ResponseEntity<?> getRefrigeratorId(@PathVariable(value = "refrigeratorId") int refrigeratorId) {
        return ResponseEntity.ok().body(this.refrigeratorService.getRefrigeratorId(refrigeratorId));
    }
}
