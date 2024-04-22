package com.example.information_systems_and_service_test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "technic")
public class Technic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @OneToMany
    @JoinColumn(name = "equipment_type_id", referencedColumnName = "id")
    private EquipmentType equipmentType;

    @Column(name = "name")
    private String name;

    @Column(name = "producer_country")
    private String producerCountry;

    @Column(name = "company_manufacturers")
    private String companyManufacturers;

    @Column(name = "online_option")
    private Boolean onlineOption;

    @Column(name = "installment_option")
    private Boolean installmentOption;

    @OneToMany(mappedBy = "technic")
    private List<Model> models;

    public Technic() {
    }

    public Technic(EquipmentType equipmentType, String name, String producerCountry,
                   String companyManufacturers, Boolean onlineOption, Boolean installmentOption) {
        this.equipmentType = equipmentType;
        this.name = name;
        this.producerCountry = producerCountry;
        this.companyManufacturers = companyManufacturers;
        this.onlineOption = onlineOption;
        this.installmentOption = installmentOption;
    }
}
