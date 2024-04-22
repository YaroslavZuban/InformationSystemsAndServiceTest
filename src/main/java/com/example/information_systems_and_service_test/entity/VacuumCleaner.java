package com.example.information_systems_and_service_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "vacuum_cleaners")
public class VacuumCleaner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private List<Model> models;

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

    public void addList(Model model){
        if(models==null){
            models = new ArrayList<>();
        }

        models.add(model);
    }
}
