package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.entity.Computer;
import com.example.information_systems_and_service_test.entity.Computer;
import com.example.information_systems_and_service_test.exception.ResourceNotFoundException;
import com.example.information_systems_and_service_test.repository.ComputerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComputerServiceImpl implements ComputerService {
    private final EntityManagerFactory entityManagerFactory;
    private final ComputerRepository computerRepository;
    @Override
    public List<Computer> getComputerFilterList(String category, String processorType) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Computer> query = builder.createQuery(Computer.class);
        Root<Computer> root = query.from(Computer.class);

        List<Predicate> predicates = new ArrayList<>();

        if (category != null && !category.isEmpty()) {
            predicates.add(builder.equal(root.get("category"), category));
        }

        if (processorType != null && !processorType.isEmpty()) {
            predicates.add(builder.equal(root.get("processorType"), processorType));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Computer getComputerId(int id) {
        return this.computerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Данного компьютера по заданному id: " + id + " не существует")
        );
    }

    @Override
    public void save(Computer computer) {
        computerRepository.save(computer);
    }
}
