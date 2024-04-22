package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.entity.Computer;
import com.example.information_systems_and_service_test.entity.Television;
import com.example.information_systems_and_service_test.entity.VacuumCleaner;

import java.util.List;

public interface VacuumCleanerService {
    List<VacuumCleaner> getVacuumCleanerFilterList(Integer dustCollectorCapacity, Integer modeCount);

    VacuumCleaner getVacuumCleanerId(int id);

    void save(VacuumCleaner vacuumCleaner);
}
