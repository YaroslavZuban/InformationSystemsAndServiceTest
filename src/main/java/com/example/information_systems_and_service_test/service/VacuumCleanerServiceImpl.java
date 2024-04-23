package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.entity.VacuumCleaner;
import com.example.information_systems_and_service_test.exception.ResourceNotFoundException;
import com.example.information_systems_and_service_test.repository.VacuumCleanerRepository;
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
public class VacuumCleanerServiceImpl implements VacuumCleanerService {
    private final EntityManagerFactory entityManagerFactory;
    private final VacuumCleanerRepository vacuumCleanerRepository;


    @Override
    public List<VacuumCleaner> getVacuumCleanerFilterList(Integer dustCollectorCapacity, Integer modeCount) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<VacuumCleaner> query = builder.createQuery(VacuumCleaner.class);
        Root<VacuumCleaner> root = query.from(VacuumCleaner.class);

        List<Predicate> predicates = new ArrayList<>();

        if (dustCollectorCapacity != null) {
            predicates.add(builder.equal(root.get("dustCollectorCapacity"), dustCollectorCapacity));
        }

        if (modeCount != null) {
            predicates.add(builder.equal(root.get("modeCount"), modeCount));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public VacuumCleaner getVacuumCleanerId(int id) {
        return this.vacuumCleanerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Данной пылесосу по заданному id: " + id + " не существует")
        );
    }

    @Override
    public void save(VacuumCleaner vacuumCleaner) {
        vacuumCleanerRepository.save(vacuumCleaner);
    }
}
