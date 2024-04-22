package com.example.information_systems_and_service_test.repository;

import com.example.information_systems_and_service_test.entity.Refrigerator;
import com.example.information_systems_and_service_test.entity.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefrigeratorRepository extends JpaRepository<Refrigerator,IllegalAccessError> {
    Optional<Refrigerator> findById(int id);
}
