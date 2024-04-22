package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.entity.Smartphone;
import com.example.information_systems_and_service_test.entity.Smartphone;
import com.example.information_systems_and_service_test.exception.ResourceNotFoundException;
import com.example.information_systems_and_service_test.repository.SmartphoneRepository;
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
public class SmartphoneServiceImpl implements SmartphoneService {
    public final EntityManagerFactory entityManagerFactory;
    private final SmartphoneRepository smartphoneRepository;

    @Override
    public List<Smartphone> getSmartphoneFilterList(String memory, Integer cameraCount) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Smartphone> query = builder.createQuery(Smartphone.class);
        Root<Smartphone> root = query.from(Smartphone.class);

        List<Predicate> predicates = new ArrayList<>();

        if (memory != null && !memory.isEmpty()) {
            predicates.add(builder.equal(root.get("memory"), memory));
        }

        if (cameraCount != null) {
            predicates.add(builder.equal(root.get("cameraCount"), cameraCount));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Smartphone getSmartphoneId(int id) {
        return this.smartphoneRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Данного смартфона по заданному id: " + id + " не существует")
        );
    }
}
