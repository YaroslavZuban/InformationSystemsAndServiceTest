package com.example.information_systems_and_service_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "equipment_type")
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "technic_type")
    private String technicType;

    @ManyToOne
    @JsonIgnore
    private List<Technic> technics;

    public EquipmentType() {
    }

    public EquipmentType(String technicType) {
        this.technicType = technicType;
    }
}
