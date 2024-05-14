package com.nuggets.advDB.service.impl;


import com.nuggets.advDB.model.MaintenanceTask;
import com.nuggets.advDB.model.repository.*;
import com.nuggets.advDB.service.MaintenanceTaskService;
import com.nuggets.advDB.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MaintenanceTaskServiceImpl implements MaintenanceTaskService {

    @Autowired
    private final MaintenanceTaskRepository maintenanceTaskRepository;

    @Autowired
    private final RepairOrderRepository repairOrderRepository;

    @Autowired
    private final ComponentRepository componentRepository;

    @Autowired
    private final ServiceCenterRepository serviceCenterRepository;

    @Autowired
    private final CarRepository carRepository;

    @Autowired
    private final RepairOrderService repairOrderService;


    public MaintenanceTaskServiceImpl(MaintenanceTaskRepository maintenanceTaskRepository, RepairOrderRepository repairOrderRepository, ComponentRepository componentRepository, ServiceCenterRepository serviceCenterRepository,
                                      CarRepository carRepository, RepairOrderService repairOrderService) {
        this.maintenanceTaskRepository = maintenanceTaskRepository;
        this.repairOrderRepository = repairOrderRepository;
        this.componentRepository = componentRepository;
        this.serviceCenterRepository = serviceCenterRepository;
        this.carRepository = carRepository;
        this.repairOrderService = repairOrderService;
    }


    @Override
    public void insertMaintenanceTask(LocalDate taskDate, Double price, Long centerID, String plateNO, Long orderID, String componentModel) {
        if (serviceCenterRepository.findById(centerID).isEmpty()) {
            throw new IllegalArgumentException("Service Center with ID " + centerID + " does not exist");
        }

        if (repairOrderRepository.findById(orderID).isEmpty()) {
            throw new IllegalArgumentException("Order with ID " + orderID + " does not exist");
        }

        if (componentRepository.findByModel(componentModel).isEmpty()) {
            throw new IllegalArgumentException("Component with model " + componentModel + " does not exist");
        }

        maintenanceTaskRepository.save(new MaintenanceTask(taskDate, price, serviceCenterRepository.findById(centerID).get(),
                carRepository.findByPlateNo(plateNO).get(), repairOrderRepository.findById(orderID).get()));

        repairOrderService.updateRepairOrderTotalCost(orderID, price);

    }
}
