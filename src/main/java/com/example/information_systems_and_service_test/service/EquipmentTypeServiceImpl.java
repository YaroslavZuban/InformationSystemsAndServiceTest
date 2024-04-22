package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.entity.EquipmentType;
import com.example.information_systems_and_service_test.exception.ResourceNotFoundException;
import com.example.information_systems_and_service_test.repository.EquipmentTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EquipmentTypeServiceImpl implements EquipmentTypeService {
    private final EquipmentTypeRepository equipmentTypeRepository;

    @Override
    public EquipmentType getEquipmentType(String name) {
        return equipmentTypeRepository.findByTechnicType(name)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Данного типа по заданному имени: " + name + " не существует")
                );
    }

    @Override
    public EquipmentType getEquipmentTypeSerialNumber(String serialNumber) {
        return equipmentTypeRepository.getEquipmentTypeSerialNumber(serialNumber)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Данного типа по заданному serial number: " + serialNumber + " не существует")
                );
    }
}