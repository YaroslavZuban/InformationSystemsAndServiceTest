package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.entity.Computer;
import com.example.information_systems_and_service_test.entity.Smartphone;

import java.util.List;

public interface SmartphoneService {
    List<Smartphone> getSmartphoneFilterList(String memory, Integer cameraCount);

    Smartphone getSmartphoneId(int id);

    void save(Smartphone smartphone);
}
