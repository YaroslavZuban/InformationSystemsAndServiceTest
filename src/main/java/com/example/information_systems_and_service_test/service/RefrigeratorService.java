package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.entity.Computer;
import com.example.information_systems_and_service_test.entity.Refrigerator;
import com.example.information_systems_and_service_test.entity.Television;

import java.util.List;

public interface RefrigeratorService {
     List<Refrigerator> getRefrigeratorFilterList(Integer doorsCount, String compressorType);
    Refrigerator getRefrigeratorId(int id);

    void save(Refrigerator refrigerator);
}
