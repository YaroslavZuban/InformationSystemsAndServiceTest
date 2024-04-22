package com.example.information_systems_and_service_test.service;

import com.example.information_systems_and_service_test.controller.data_creation.ModelIntermediate;
import com.example.information_systems_and_service_test.controller.data_creation.ObjectIntermediate;
import com.example.information_systems_and_service_test.entity.*;
import com.example.information_systems_and_service_test.exception.ResourceNotFoundException;
import com.example.information_systems_and_service_test.repository.ModelRepository;
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
public class ModelServiceImpl implements ModelService {
    private final EntityManagerFactory entityManagerFactory;
    private final ModelRepository modelRepository;
    private final TechnicService technicService;
    private final EquipmentTypeService equipmentTypeService;

    private final ComputerService computerService;
    private final RefrigeratorService refrigeratorService;
    private final SmartphoneService smartphoneService;
    private final TelevisionService televisionService;
    private final VacuumCleanerService vacuumCleanerService;

    @Override
    public List<Model> getModelFilterList(String serialNumber, String color,
                                          Integer size, Integer price,
                                          Boolean productAvailability) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Model> query = builder.createQuery(Model.class);
        Root<Model> root = query.from(Model.class);

        List<Predicate> predicates = new ArrayList<>();

        if (serialNumber != null && !serialNumber.isEmpty()) {
            predicates.add(builder.equal(root.get("serialNumber"), serialNumber));
        }

        if (color != null && !color.isEmpty()) {
            predicates.add(builder.equal(root.get("color"), color));
        }

        if (size != null) {
            predicates.add(builder.equal(root.get("size"), size));
        }

        if (price != null) {
            predicates.add(builder.equal(root.get("price"), price));
        }

        if (productAvailability != null) {
            predicates.add(builder.equal(root.get("productAvailability"), productAvailability));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Model getModelId(Integer id) {
        return this.modelRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Данной модели по заданному id: " + id + " не существует")
        );
    }

    @Override
    public void createModel(ModelIntermediate modelIntermediate) {
        Technic technic = this.technicService.getTechnicName(modelIntermediate.technic());

        if (!technic.getEquipmentType().getTechnicType().equals(modelIntermediate.technicType())) {
            throw new ResourceNotFoundException("Данной техники: " + modelIntermediate.technic()
                    + " с таким типом: " + modelIntermediate.technicType() + " не существует");
        }

        Model newModel = new Model(modelIntermediate.serialNumber(), modelIntermediate.color(),
                modelIntermediate.size(), modelIntermediate.price(), modelIntermediate.productAvailability());

        List<Model> technicList = technic.getModels();

        technicList.add(newModel);
        newModel.setTechnic(technic);

        this.modelRepository.save(newModel);
    }

    @Override
    public void createObject(ObjectIntermediate objectIntermediate) {
        String serialNumber = objectIntermediate.serialNumber();

        EquipmentType equipmentType = equipmentTypeService.getEquipmentTypeSerialNumber(serialNumber);

        if (!equipmentType.getTechnicType().equals(objectIntermediate.equipmentType())) {
            throw new ResourceNotFoundException("Данного типа: " + objectIntermediate.equipmentType() + " не существует");
        }

        Model model = modelRepository.findBySerialNumber(serialNumber)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Данной модели по заданному serial number: " + serialNumber + " не существует")
                );

        // Да понимаю что данный код не хороший т.к значения захардкожены
        switch (equipmentType.getTechnicType()) {
            case "Телевизоры" -> {
                Television television = new Television(
                        (String) objectIntermediate.parameter_one(),
                        (String) objectIntermediate.parameter_two());
                model.setTelevision(television);
                television.addList(model);
                televisionService.save(television);
            }
            case "Пылесосы" -> {
                VacuumCleaner cleaner = new VacuumCleaner(
                        (Integer) objectIntermediate.parameter_one(),
                        (Integer) objectIntermediate.parameter_two()
                );
                model.setVacuumCleaner(cleaner);
                cleaner.addList(model);
                vacuumCleanerService.save(cleaner);
            }
            case "Холодильники" -> {
                Refrigerator refrigerator = new Refrigerator(
                        (Integer) objectIntermediate.parameter_one(),
                        (String) objectIntermediate.parameter_two());
                model.setRefrigerator(refrigerator);
                refrigerator.addList(model);
                refrigeratorService.save(refrigerator);
            }
            case "Смартфоны" -> {
                Smartphone smartphone = new Smartphone(
                        (String) objectIntermediate.parameter_one(),
                        (Integer) objectIntermediate.parameter_two()
                );
                model.setSmartphone(smartphone);
                smartphone.addList(model);
                smartphoneService.save(smartphone);
            }
            case "Компьютеры" -> {
                Computer computer = new Computer(
                        (String) objectIntermediate.parameter_one(),
                        (String) objectIntermediate.parameter_two()
                );
                model.setComputer(computer);
                computer.addList(model);
                computerService.save(computer);
            }
        }
    }
}
