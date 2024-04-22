package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.entity.EquipmentType;

public interface EquipmentTypeService {
    EquipmentType getEquipmentType(String name);
    EquipmentType getEquipmentTypeSerialNumber(String serialNumber);
}
