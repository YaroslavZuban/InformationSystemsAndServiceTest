package com.example.information_systems_and_service_test.repository;

import com.example.information_systems_and_service_test.entity.Smartphone;
import com.example.information_systems_and_service_test.entity.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone,Integer> {
    Optional<Smartphone> findById(int id);
}
