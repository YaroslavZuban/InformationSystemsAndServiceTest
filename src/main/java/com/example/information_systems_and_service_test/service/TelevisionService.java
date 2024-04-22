package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.entity.Computer;
import com.example.information_systems_and_service_test.entity.Model;
import com.example.information_systems_and_service_test.entity.Technic;
import com.example.information_systems_and_service_test.entity.Television;

import java.util.List;
import java.util.Optional;

public interface TelevisionService {
    List<Television> getTelevisionFilterList(String category, String technology);
    Television getTelevisionId(int id);

    void save(Television television);
}
