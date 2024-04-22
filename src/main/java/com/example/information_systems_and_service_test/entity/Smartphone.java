package com.example.information_systems_and_service_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "smartphones")
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private List<Model> models;

    @Column(name = "memory")
    private String memory;

    @Column(name = "cameraCount")
    private Integer cameraCount;

    public Smartphone() {
    }

    public Smartphone(String memory, Integer cameraCount) {
        this.memory = memory;
        this.cameraCount = cameraCount;
    }

    public void addList(Model model){
        if(models==null){
            models = new ArrayList<>();
        }

        models.add(model);
    }
}
