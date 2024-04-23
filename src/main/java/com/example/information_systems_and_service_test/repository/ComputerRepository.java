package com.example.information_systems_and_service_test.repository;

import com.example.information_systems_and_service_test.entity.Computer;
import com.example.information_systems_and_service_test.entity.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComputerRepository extends JpaRepository<Computer,Integer> {
    @Query("SELECT c FROM Computer c WHERE c.id=:id")
    Optional<Computer> findById(@Param("id") int id);
}
