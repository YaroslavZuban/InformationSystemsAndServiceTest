package com.example.information_systems_and_service_test.repository;

import com.example.information_systems_and_service_test.entity.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Integer> {
    Optional<EquipmentType> findByTechnicType(String technicType);

    @Query(value = "SELECT e.id, e.technic_type " +
            "FROM equipment_type as e" +
            "         INNER JOIN (SELECT equipment_type_id" +
            "                     FROM technic" +
            "                              INNER JOIN (SELECT technic_id, serial_number" +
            "                                          FROM model" +
            "                                          WHERE model.serial_number = :serialNumber) ON technic_id = technic.id)" +
            "                    ON equipment_type_id = e.id;"
            , nativeQuery = true)
    Optional<EquipmentType> getEquipmentTypeSerialNumber(@Param("serialNumber") String serialNumber);
}
