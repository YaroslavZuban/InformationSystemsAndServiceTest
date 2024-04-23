package com.example.information_systems_and_service_test.controller;

import com.example.information_systems_and_service_test.entity.Computer;
import com.example.information_systems_and_service_test.entity.Computer;
import com.example.information_systems_and_service_test.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("equipment-register-api/model/computer")
public class ComputerRestController {
    private final ComputerService computerService;

    @GetMapping("/search-filter")
    public ResponseEntity<?> getComputerSearch(@RequestParam(value = "category", required = false) String category,
                                            @RequestParam(value = "processorType", required = false) String processorType) {
        return ResponseEntity.ok().body(this.computerService.getComputerFilterList(category, processorType));
    }

    @GetMapping("/{computerId:\\d++}")
    public ResponseEntity<?> getComputerId(@PathVariable(value = "computerId") int computerId) {
        return ResponseEntity.ok().body(this.computerService.getComputerId(computerId));
    }
}
