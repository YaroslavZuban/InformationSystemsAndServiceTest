package com.example.information_systems_and_service_test.controller.data_creation;

import lombok.NonNull;

public record TechnicIntermediate(
        @NonNull
        String technicType,
        @NonNull
        String name,
        @NonNull
        String producerCountry,
        @NonNull
        String companyManufacturers,
        @NonNull
        Boolean isOnlineOption,
        @NonNull
        Boolean isInstallmentOption) {
}
