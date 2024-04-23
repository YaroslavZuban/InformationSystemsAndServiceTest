package com.example.information_systems_and_service_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_seq")
    @SequenceGenerator(name = "model_seq", sequenceName = "model_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "technic_id", referencedColumnName = "id")
    private Technic technic;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private Integer size;

    @Column(name = "price")
    private Double price;

    @Column(name = "product_availability")
    private Boolean productAvailability;

    @OneToMany(mappedBy = "model")
    private List<Television> televisions;

    @OneToMany(mappedBy = "model")
    private List<VacuumCleaner> vacuumCleaners;

    @OneToMany(mappedBy = "model")
    private List<Refrigerator> refrigerators;

    @OneToMany(mappedBy = "model")
    private List<Smartphone> smartphones;

    @OneToMany(mappedBy = "model")
    private List<Computer> computers;


    public Model() {
    }

    public Model(String serialNumber, String color,
                 Integer size, Double price, Boolean productAvailability) {
        this.serialNumber = serialNumber;
        this.color = color;
        this.size = size;
        this.price = price;
        this.productAvailability = productAvailability;
    }

    public void addComputerList(Computer computer){
        if(computers==null){
            computers = new ArrayList<>();
        }

        computers.add(computer);
    }

    public void addTelevisionList(Television television){
        if(televisions==null){
            televisions = new ArrayList<>();
        }

        televisions.add(television);
    }

    public void addVacuumCleanerList(VacuumCleaner vacuumCleaner){
        if(vacuumCleaners==null){
            vacuumCleaners = new ArrayList<>();
        }

        vacuumCleaners.add(vacuumCleaner);
    }

    public void addRefrigeratorList(Refrigerator refrigerator){
        if(refrigerators==null){
            refrigerators = new ArrayList<>();
        }

        refrigerators.add(refrigerator);
    }

    public void addSmartphoneList(Smartphone smartphone){
        if(smartphones==null){
            smartphones = new ArrayList<>();
        }

        smartphones.add(smartphone);
    }
}
