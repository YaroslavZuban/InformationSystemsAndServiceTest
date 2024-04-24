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
@Table(name = "televisions")
public class Television {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "televisions_id_seq")
    @SequenceGenerator(name = "televisions_id_seq", sequenceName = "televisions_id_seq", allocationSize = 1)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "model_t_id",referencedColumnName = "id")
    private Model model;

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
}