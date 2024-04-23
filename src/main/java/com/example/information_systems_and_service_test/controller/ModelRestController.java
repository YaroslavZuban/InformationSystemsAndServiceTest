package com.example.information_systems_and_service_test.controller;

import com.example.information_systems_and_service_test.controller.data_creation.ModelIntermediate;
import com.example.information_systems_and_service_test.controller.data_creation.ObjectIntermediate;
import com.example.information_systems_and_service_test.controller.data_creation.TechnicIntermediate;
import com.example.information_systems_and_service_test.entity.Model;
import com.example.information_systems_and_service_test.entity.Technic;
import com.example.information_systems_and_service_test.service.ModelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("equipment-register-api/model")
public class ModelRestController {
    private final ModelService modelService;

    @GetMapping("/search-filter")
    public ResponseEntity<List<Model>> getTechnicSearch(@RequestParam(value = "serialNumber", required = false) String serialNumber,
                                                        @RequestParam(value = "size", required = false) Integer size,
                                                        @RequestParam(value = "color", required = false) String color,
                                                        @RequestParam(value = "price", required = false) Integer price,
                                                        @RequestParam(value = "productAvailability", required = false) Boolean productAvailability) {
        return ResponseEntity.ok().body(this.modelService.getModelFilterList(serialNumber, color, size, price, productAvailability));
    }

    @GetMapping("/{modelId:\\d}")
    public ResponseEntity<Model> getModelId(@PathVariable(value = "modelId") int modelId) {
        return ResponseEntity.ok().body(this.modelService.getModelId(modelId));
    }

    @PostMapping(value = "/create-model", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTechnic(@Valid @RequestBody(required = false) ModelIntermediate modelIntermediate) {
        this.modelService.createModel(modelIntermediate);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/create-model-object", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTechnic(@Valid @RequestBody(required = false) ObjectIntermediate objectIntermediate) {
        this.modelService.createObject(objectIntermediate);
        return ResponseEntity.ok().build();
    }
}
