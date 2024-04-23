package com.example.information_systems_and_service_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "computers")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "computers_seq")
    @SequenceGenerator(name = "computers_seq", sequenceName = "computers_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "model_c_id",referencedColumnName = "id")
    private Model model;

    @Column(name = "category")
    private String category;

    @Column(name = "processor_type")
    private String processorType;

    public Computer() {
    }

    public Computer(String category, String processorType) {
        this.category = category;
        this.processorType = processorType;
    }
}
