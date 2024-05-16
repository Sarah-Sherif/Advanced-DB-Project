package com.advDB.carServiceCenter.service.impl;


import com.advDB.carServiceCenter.model.Engine;
import com.advDB.carServiceCenter.model.repositories.ComponentRepository;
import com.advDB.carServiceCenter.model.repositories.EngineRepository;
import com.advDB.carServiceCenter.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EngineServiceImpl implements EngineService {

    @Autowired
    private final EngineRepository engineRepository;

    @Autowired
    private final ComponentRepository componentRepository;

    public EngineServiceImpl(EngineRepository engineRepository, ComponentRepository componentRepository) {
        this.engineRepository = engineRepository;
        this.componentRepository = componentRepository;
    }

    @Override
    public void insertEngine(String model, String lubricantType, int horsePower, Double price) {
        if (componentRepository.findByComponentModel(model).isEmpty()) {
            throw new IllegalArgumentException("Engine with model " + model + " does not exist");
        }
        engineRepository.save(new Engine(model, lubricantType, horsePower, price));
    }
}
