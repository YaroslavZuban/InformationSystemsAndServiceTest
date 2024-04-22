package com.example.information_systems_and_service_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne
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

    @OneToMany(mappedBy = "models")
    private Television television;

    @OneToMany(mappedBy = "models")
    private VacuumCleaner vacuumCleaner;

    @OneToMany(mappedBy = "models")
    private Refrigerator refrigerator;

    @OneToMany(mappedBy = "models")
    private Smartphone smartphone;

    @OneToMany(mappedBy = "models")
    private Computer computer;

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
}
