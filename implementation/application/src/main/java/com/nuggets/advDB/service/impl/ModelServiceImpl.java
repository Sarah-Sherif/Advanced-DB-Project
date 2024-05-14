package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Model;
import com.nuggets.advDB.model.ModelId;
import com.nuggets.advDB.model.repository.ModelRepository;
import com.nuggets.advDB.service.ModelService;
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
