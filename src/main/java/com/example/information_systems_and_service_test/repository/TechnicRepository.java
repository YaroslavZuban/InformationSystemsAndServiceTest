package com.example.information_systems_and_service_test.repository;

import com.example.information_systems_and_service_test.entity.Technic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TechnicRepository extends JpaRepository<Technic, Integer> {
    @Query(value = "SELECT t " +
            "FROM technic as t " +
            "INNER JOIN model ON model.technic_id=t.id " +
            "ORDER BY price",
            nativeQuery = true)
    List<Technic> getPriceSortAsc();

    @Query(value = "SELECT t " +
            "FROM technic as t " +
            "INNER JOIN model ON model.technic_id=t.id " +
            "ORDER BY price DESC",
            nativeQuery = true)
    List<Technic> getPriceSortDesc();

    List<Technic> findAllByOrderByNameAsc();

    List<Technic> findAllByOrderByNameDesc();

    Optional<Technic> findById(int id);
    Optional<Technic> findByName(String name);
}
