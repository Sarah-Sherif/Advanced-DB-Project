package com.nuggets.advDB.service.impl;


import com.nuggets.advDB.model.Perform;
import com.nuggets.advDB.model.PerformId;
import com.nuggets.advDB.model.repository.EngineerRepository;
import com.nuggets.advDB.model.repository.MaintenanceTaskRepository;
import com.nuggets.advDB.model.repository.PerformRepository;
import com.nuggets.advDB.service.PerformsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformsServiceImpl implements PerformsService {

    @Autowired
    private final PerformRepository performRepository;

    @Autowired
    private final MaintenanceTaskRepository maintenanceTaskRepository;

    @Autowired
    private final EngineerRepository engineerRepository;

    public PerformsServiceImpl(PerformRepository performRepository, MaintenanceTaskRepository maintenanceTaskRepository, EngineerRepository engineerRepository) {
        this.performRepository = performRepository;
        this.maintenanceTaskRepository = maintenanceTaskRepository;
        this.engineerRepository = engineerRepository;
    }

    @Override
    public void insertPerforms(String ssn, Long taskID) {
        PerformId performId = new PerformId(ssn, taskID);
        performRepository.save(new Perform(performId, engineerRepository.findByESsn(ssn).get(), maintenanceTaskRepository.findById(taskID).get()));
    }
}
