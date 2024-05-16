package com.advDB.carServiceCenter.service.impl;

import com.advDB.carServiceCenter.model.RepairOrder;
import com.advDB.carServiceCenter.model.repositories.CustomerRepository;
import com.advDB.carServiceCenter.model.repositories.MaintenanceTaskRepository;
import com.advDB.carServiceCenter.model.repositories.OrderRepository;
import com.advDB.carServiceCenter.model.repositories.RepairOrderRepository;
import com.advDB.carServiceCenter.service.OrderService;
import com.advDB.carServiceCenter.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairOrderServiceImpl implements RepairOrderService {

    @Autowired
    private final RepairOrderRepository repairOrderRepository;

    @Autowired
    private final OrderService orderService;

    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final MaintenanceTaskRepository maintenanceTaskRepository;

    public RepairOrderServiceImpl(RepairOrderRepository repairOrderRepository, OrderService orderService, CustomerRepository customerRepository, OrderRepository orderRepository, MaintenanceTaskRepository maintenanceTaskRepository) {
        this.repairOrderRepository = repairOrderRepository;
        this.orderService = orderService;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.maintenanceTaskRepository = maintenanceTaskRepository;
    }

    @Override
    public void insertRepairOrder(String status, String paymentMethod, String date, String customerSSN, String city, Integer streetNo, Integer buildingNo, String district, String taskId) {
        orderService.insertOrder(status, paymentMethod, date);
        repairOrderRepository.save(new RepairOrder(city, district, buildingNo, customerRepository.findBySsn(Long.valueOf(customerSSN)).get(), maintenanceTaskRepository.findById(taskId).get()));
    }

}
