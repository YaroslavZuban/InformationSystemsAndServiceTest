package com.example.information_systems_and_service_test.controller;

import com.example.information_systems_and_service_test.entity.Computer;
import com.example.information_systems_and_service_test.entity.Computer;
import com.example.information_systems_and_service_test.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("equipment-register-api/model/computer")
public class ComputerRestController {
    private final ComputerService computerService;

    @GetMapping("/search-filter")
    public List<Computer> getComputerSearch(@RequestParam(value = "category", required = false) String category,
                                            @RequestParam(value = "processorType", required = false) String processorType) {
        return this.computerService.getComputerFilterList(category, processorType);
    }

    @GetMapping("/{computerId:d++}")
    public Computer getComputerId(@PathVariable(value = "computerId") int computerId) {
        return this.computerService.getComputerId(computerId);
    }
}
