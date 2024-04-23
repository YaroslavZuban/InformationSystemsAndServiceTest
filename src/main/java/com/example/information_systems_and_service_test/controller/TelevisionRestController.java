package com.example.information_systems_and_service_test.controller;

import com.example.information_systems_and_service_test.entity.Model;
import com.example.information_systems_and_service_test.entity.Television;
import com.example.information_systems_and_service_test.service.TelevisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("equipment-register-api/model/television")
public class TelevisionRestController {
    private final TelevisionService televisionService;

    @GetMapping("/search-filter")
    public ResponseEntity<?> getTelevisionSearch(@RequestParam(value = "category", required = false) String category,
                                              @RequestParam(value = "technology", required = false) String technology) {
        return ResponseEntity.ok().body(this.televisionService.getTelevisionFilterList(category, technology));
    }

    @GetMapping("/{televisionId:\\d}")
    public ResponseEntity<?> getTelevisionId(@PathVariable(value = "televisionId") int televisionId) {
        return ResponseEntity.ok().body(this.televisionService.getTelevisionId(televisionId));
    }
}
