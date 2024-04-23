package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.entity.Television;
import com.example.information_systems_and_service_test.exception.ResourceNotFoundException;
import com.example.information_systems_and_service_test.repository.TelevisionRepository;
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
public class TelevisionServiceImpl implements TelevisionService {
    private final TelevisionRepository televisionRepository;
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<Television> getTelevisionFilterList(String category, String technology) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Television> criteriaQuery = criteriaBuilder.createQuery(Television.class);
        Root<Television> root = criteriaQuery.from(Television.class);

        List<Predicate> predicates = new ArrayList<>();

        if (category != null && !category.isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("category"), category));
        }

        if (technology != null && !technology.isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("technology"), technology));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Television getTelevisionId(int id) {
        return televisionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Данного телевизора по заданному id: " + id + " не существует")
        );
    }

    @Override
    public void save(Television television) {
        televisionRepository.save(television);
    }


}
