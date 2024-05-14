package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Engine;
import com.nuggets.advDB.model.repository.ComponentRepository;
import com.nuggets.advDB.model.repository.EngineRepository;
import com.nuggets.advDB.service.EngineService;
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
    public void insertEngine(String model, String lubricantType, int horsePower) {
        if (componentRepository.findByModel(model).isEmpty()) {
            throw new IllegalArgumentException("Engine with model " + model + " does not exist");
        }
        engineRepository.save(new Engine(model, lubricantType, horsePower));
    }
}
