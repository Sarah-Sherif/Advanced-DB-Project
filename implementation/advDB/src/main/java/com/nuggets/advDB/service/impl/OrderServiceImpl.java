package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Order;
import com.nuggets.advDB.model.repository.OrderRepository;
import com.nuggets.advDB.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void insertOrder(String status, String paymentMethod, LocalDate date) {
        orderRepository.save(new Order(status, paymentMethod, date));
    }
}
