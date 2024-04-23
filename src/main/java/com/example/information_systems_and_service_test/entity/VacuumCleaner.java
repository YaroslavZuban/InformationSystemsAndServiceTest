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
@Table(name = "vacuum_cleaners")
public class VacuumCleaner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacuum_cleaners_seq")
    @SequenceGenerator(name = "vacuum_cleaners_seq", sequenceName = "vacuum_cleaners_seq", allocationSize = 1)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "model_v_id",referencedColumnName = "id")
    private Model model;

    @Column(name = "dust_collector_capacity")
    private Integer dustCollectorCapacity;

    @Column(name = "mode_count")
    private Integer modeCount;

    public VacuumCleaner() {
    }

    public VacuumCleaner(Integer dustCollectorCapacity, Integer modeCount) {
        this.dustCollectorCapacity = dustCollectorCapacity;
        this.modeCount = modeCount;
    }
}
