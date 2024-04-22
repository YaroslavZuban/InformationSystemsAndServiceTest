package com.example.information_systems_and_service_test.controller.data_creation;

import com.example.information_systems_and_service_test.entity.Technic;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.NonNull;

public record ModelIntermediate(
        @NonNull
        String technicType,
        @NonNull
        String technic,
        @NonNull
        String serialNumber,
        @NonNull
        String color,
        @NonNull
        Integer size,
        @NonNull
        Double price,
        @NonNull
        Boolean productAvailability
) {
}
