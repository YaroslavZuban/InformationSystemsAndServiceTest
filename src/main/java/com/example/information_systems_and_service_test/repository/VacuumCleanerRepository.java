package com.example.information_systems_and_service_test.repository;

import com.example.information_systems_and_service_test.entity.VacuumCleaner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacuumCleanerRepository extends JpaRepository<VacuumCleaner, Integer> {
    Optional<VacuumCleaner> findById(int id);
}
