package com.example.information_systems_and_service_test.repository;

import com.example.information_systems_and_service_test.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {
    Optional<Model> findById(int id);
    Optional<Model> findBySerialNumber(String serialNumber);
}
