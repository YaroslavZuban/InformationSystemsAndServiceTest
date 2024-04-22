package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.controller.data_creation.TechnicIntermediate;
import com.example.information_systems_and_service_test.entity.EquipmentType;
import com.example.information_systems_and_service_test.entity.Model;
import com.example.information_systems_and_service_test.entity.Technic;
import com.example.information_systems_and_service_test.exception.ResourceNotFoundException;
import com.example.information_systems_and_service_test.repository.TechnicRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnicServiceImpl implements TechnicService {
    private final TechnicRepository technicRepository;
    private final EntityManagerFactory entityManagerFactory;
    private final EquipmentTypeService equipmentTypeService;

    @Override
    public void createTechnic(TechnicIntermediate technicIntermediate) {
        EquipmentType equipmentType = this.equipmentTypeService.getEquipmentType(technicIntermediate.technicType());

        Technic newTechnic = new Technic(equipmentType, technicIntermediate.name(), technicIntermediate.producerCountry(),
                technicIntermediate.companyManufacturers(), technicIntermediate.isOnlineOption(),
                technicIntermediate.isInstallmentOption());

        List<Technic> technicList = equipmentType.getTechnics();
        technicList.add(newTechnic);

        equipmentType.setTechnics(technicList);

        technicRepository.save(newTechnic);
    }

    @Override
    public Technic getTechnicId(Integer id) {
        return technicRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Данной техники по заданному id: " + id + " не существует"));
    }

    @Override
    public List<Technic> getNameSort(boolean isNameSortAsc) {
        return isNameSortAsc ? technicRepository.findAllByOrderByNameAsc() : technicRepository.findAllByOrderByNameDesc();
    }

    @Override
    public List<Technic> getPriceSort(boolean isPriceSortAsc) {
        return isPriceSortAsc ? technicRepository.getPriceSortAsc() : technicRepository.getPriceSortDesc();
    }

    @Override
    public List<Technic> getTechnicSearchList(String name, String technicType, String color, Boolean isPriceSortAsc) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Technic> query = builder.createQuery(Technic.class);
        Root<Technic> root = query.from(Technic.class);

        List<Predicate> predicates = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            predicates.add(builder.equal(builder.lower(root.get("name")), name.toLowerCase()));
        }

        if (technicType != null && !technicType.isEmpty()) {
            Join<Technic, EquipmentType> equipmentTypeJoin = root.join("equipmentType", JoinType.INNER);
            predicates.add(builder.equal(equipmentTypeJoin.get("technicType"), technicType));
        }

        if (color != null && !color.isEmpty()) {
            Join<Technic, Model> modelJoin = root.join("models", JoinType.INNER);
            predicates.add(builder.equal(modelJoin.get("color"), color));
        }

        query.where(predicates.toArray(new Predicate[0]));

        if (isPriceSortAsc != null) {
            Join<Technic, Model> modelJoin = root.join("models", JoinType.INNER);

            if (isPriceSortAsc) {
                query.orderBy(builder.asc(modelJoin.get("price")));
            } else {
                query.orderBy(builder.desc(modelJoin.get("price")));
            }
        }

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Technic getTechnicName(String name) {
        return this.technicRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Данной техники по заданному namme: " + name + " не существует"));

    }
}
