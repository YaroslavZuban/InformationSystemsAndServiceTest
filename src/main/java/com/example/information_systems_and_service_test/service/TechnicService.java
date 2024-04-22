package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.controller.data_creation.TechnicIntermediate;
import com.example.information_systems_and_service_test.entity.Technic;

import java.util.List;
import java.util.Optional;

public interface TechnicService {
    void createTechnic(TechnicIntermediate technicIntermediate);
    Technic getTechnicId(Integer id);

    List<Technic> getNameSort(boolean isNameSortAsc);

    List<Technic> getPriceSort(boolean isPriceSortAsc);

    List<Technic> getTechnicSearchList(String name, String technicType, String color, Boolean isPriceSortAsc);

    Technic getTechnicName(String name);
}
