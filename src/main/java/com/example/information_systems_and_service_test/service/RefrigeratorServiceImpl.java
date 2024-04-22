package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.entity.Refrigerator;
import com.example.information_systems_and_service_test.entity.VacuumCleaner;
import com.example.information_systems_and_service_test.exception.ResourceNotFoundException;
import com.example.information_systems_and_service_test.repository.RefrigeratorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RefrigeratorServiceImpl implements RefrigeratorService {
    private final RefrigeratorRepository refrigeratorRepository;
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<Refrigerator> getRefrigeratorFilterList(Integer doorsCount, String compressorType) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Refrigerator> query = builder.createQuery(Refrigerator.class);
        Root<Refrigerator> root = query.from(Refrigerator.class);

        List<Predicate> predicates = new ArrayList<>();

        if (doorsCount != null) {
            predicates.add(builder.equal(root.get("doorsCount"), doorsCount));
        }

        if (compressorType != null && !compressorType.isEmpty()) {
            predicates.add(builder.equal(root.get("compressorType"), compressorType));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Refrigerator getRefrigeratorId(int id) {
        return this.refrigeratorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Данного холодильника по заданному id: " + id + " не существует")
        );
    }
}
