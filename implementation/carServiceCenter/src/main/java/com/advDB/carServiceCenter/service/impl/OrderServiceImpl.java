package com.advDB.carServiceCenter.service.impl;


import com.advDB.carServiceCenter.model.Order;
import com.advDB.carServiceCenter.model.repositories.OrderRepository;
import com.advDB.carServiceCenter.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void insertOrder(String status, String paymentMethod, String date) {
        orderRepository.save(new Order(status, paymentMethod, date));
    }
}
