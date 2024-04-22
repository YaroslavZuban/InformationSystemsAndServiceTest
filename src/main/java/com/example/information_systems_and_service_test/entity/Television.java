package com.example.information_systems_and_service_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "televisions")
public class Television {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "model_id",referencedColumnName = "id")
    private List<Model> models;

    @Column(name = "category")
    private String category;

    @Column(name = "technology")
    private String technology;

    public Television() {
    }

    public Television(String category, String technology) {
        this.category = category;
        this.technology = technology;
    }

    public void addList(Model model){
        if(models==null){
            models = new ArrayList<>();
        }

        models.add(model);
    }
}