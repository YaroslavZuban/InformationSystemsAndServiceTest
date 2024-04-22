package com.example.information_systems_and_service_test.controller;

import com.example.information_systems_and_service_test.entity.Model;
import com.example.information_systems_and_service_test.entity.Television;
import com.example.information_systems_and_service_test.service.TelevisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("equipment-register-api/model/television")
public class TelevisionRestController {
    private final TelevisionService televisionService;

    @GetMapping("/search-filter")
    public List<Television> getTelevisionSearch(@RequestParam(value = "category", required = false) String category,
                                                @RequestParam(value = "technology", required = false) String technology) {
        return this.televisionService.getTelevisionFilterList(category, technology);
    }

    @GetMapping("/{televisionId:d++}")
    public Television getTelevisionId(@PathVariable(value = "televisionId") int televisionId) {
        return this.televisionService.getTelevisionId(televisionId);
    }
}
