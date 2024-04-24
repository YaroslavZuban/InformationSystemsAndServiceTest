package com.example.information_systems_and_service_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "equipment_type")
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipment_type_id_seq")
    @SequenceGenerator(name = "equipment_type_id_seq", sequenceName = "equipment_type_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "technic_type")
    private String technicType;

    @JsonIgnore
    @OneToMany(mappedBy = "equipmentType",fetch = FetchType.EAGER)
    private List<Technic> technics;

    public EquipmentType() {
    }

    public EquipmentType(String technicType) {
        this.technicType = technicType;
    }
}
