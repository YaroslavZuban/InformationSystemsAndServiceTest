package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.entity.Computer;

import java.util.List;

public interface ComputerService {
    List<Computer> getComputerFilterList(String category, String processorType);

    Computer getComputerId(int id);

    void save(Computer computer);
}
