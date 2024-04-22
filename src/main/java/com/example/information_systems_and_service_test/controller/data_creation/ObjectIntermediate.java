package com.example.information_systems_and_service_test.controller.data_creation;

import lombok.NonNull;

public record ObjectIntermediate(
        @NonNull
        String equipmentType,
        @NonNull
        String serialNumber,
        @NonNull
        Object parameter_one,
        @NonNull
        Object parameter_two
) {
}
