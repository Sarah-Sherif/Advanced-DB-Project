package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Order;
import com.nuggets.advDB.model.RepairOrder;
import com.nuggets.advDB.model.repository.CustomerRepository;
import com.nuggets.advDB.model.repository.OrderRepository;
import com.nuggets.advDB.model.repository.RepairOrderRepository;
import com.nuggets.advDB.service.OrderService;
import com.nuggets.advDB.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RepairOrderServiceImpl implements RepairOrderService {

    @Autowired
    private final RepairOrderRepository repairOrderRepository;

    @Autowired
    private final OrderService  orderService;

    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final OrderRepository orderRepository;

    public RepairOrderServiceImpl(RepairOrderRepository repairOrderRepository, OrderService orderService, CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.repairOrderRepository = repairOrderRepository;
        this.orderService = orderService;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void insertRepairOrder(String status, String paymentMethod, LocalDate date, String customerSSN, String city, Integer streetNo, Long buildingNo, String district) {
        orderService.insertOrder(status, paymentMethod, date);
        Order order = new Order(status, paymentMethod, date);
        repairOrderRepository.save(new RepairOrder(order, customerRepository.findByCSsn(customerSSN).get(), city, streetNo, buildingNo, district));
    }

    @Override
    public void updateRepairOrderTotalCost(Long orderID, Double totalCost) {
        Order order = orderRepository.findById(orderID).get();
        order.setTotalCost(totalCost);
        orderRepository.save(order);
    }
}
