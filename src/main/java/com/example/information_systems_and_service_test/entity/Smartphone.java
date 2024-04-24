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
@Table(name = "smartphones")
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "smartphones_id_seq")
    @SequenceGenerator(name = "smartphones_id_seq", sequenceName = "smartphones_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "model_s_id",referencedColumnName = "id")
    private Model model;

    @Column(name = "memory")
    private String memory;

    @Column(name = "camera_count")
    private Integer cameraCount;

    public Smartphone() {
    }

    public Smartphone(String memory, Integer cameraCount) {
        this.memory = memory;
        this.cameraCount = cameraCount;
    }
}
