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
@Table(name = "refrigerators")
public class Refrigerator {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refrigerators_seq")
    @SequenceGenerator(name = "refrigerators_seq", sequenceName = "refrigerators_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "model_r_id",referencedColumnName = "id")
    private Model model;

    @Column(name = "doors_count")
    private Integer doorsCount;

    @Column(name = "compressor_type")
    private String compressorType;

    public Refrigerator() {
    }

    public Refrigerator(Integer doorsCount, String compressorType) {
        this.doorsCount = doorsCount;
        this.compressorType = compressorType;
    }
}
