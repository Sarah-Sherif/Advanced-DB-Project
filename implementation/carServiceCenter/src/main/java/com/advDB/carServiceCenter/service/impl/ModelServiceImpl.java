package com.advDB.carServiceCenter.service.impl;

import com.advDB.carServiceCenter.model.Model;
import com.advDB.carServiceCenter.model.ModelId;
import com.advDB.carServiceCenter.model.repositories.ModelRepository;
import com.advDB.carServiceCenter.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public void insertModel(String modelName, Integer modelYear, String brand) {
        ModelId modelId = new ModelId(modelName, modelYear);
        modelRepository.save(new Model(modelId, brand));
    }
}
