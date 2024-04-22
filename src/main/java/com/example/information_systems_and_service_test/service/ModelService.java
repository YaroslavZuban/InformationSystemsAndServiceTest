package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.controller.data_creation.ModelIntermediate;
import com.example.information_systems_and_service_test.controller.data_creation.ObjectIntermediate;
import com.example.information_systems_and_service_test.entity.Model;

import java.util.List;

public interface ModelService {
    List<Model> getModelFilterList(String serialNumber, String color,
                                   Integer size, Integer price,
                                   Boolean productAvailability);

    Model getModelId(Integer id);

    void createModel(ModelIntermediate modelIntermediate);

    void createObject(ObjectIntermediate objectIntermediate);
}
