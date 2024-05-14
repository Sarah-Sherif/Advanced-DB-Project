package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.ConsistOf;
import com.nuggets.advDB.model.ConsistOfId;
import com.nuggets.advDB.model.repository.ComponentRepository;
import com.nuggets.advDB.model.repository.ConsistOfRepository;
import com.nuggets.advDB.model.repository.OrderRepository;
import com.nuggets.advDB.service.ConsistOfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsistOfServiceImpl implements ConsistOfService {

    @Autowired
    private final ConsistOfRepository consistOfRepository;

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final ComponentRepository componentRepository;

    public ConsistOfServiceImpl(ConsistOfRepository consistOfRepository, OrderRepository orderRepository, ComponentRepository componentRepository) {
        this.consistOfRepository = consistOfRepository;
        this.orderRepository = orderRepository;
        this.componentRepository = componentRepository;
    }

    @Override
    public void insertConsistOf(Long orderID, String componentModel, Integer quantity) {

        if (orderRepository.findById(orderID).isEmpty()) {
            throw new IllegalArgumentException("Order with ID " + orderID + " does not exist");
        }

        if (componentRepository.findByModel(componentModel).isEmpty()) {
            throw new IllegalArgumentException("Component with model " + componentModel + " does not exist");
        }

        ConsistOfId consistOfId = new ConsistOfId(orderID, componentModel);
        consistOfRepository.save(new ConsistOf(consistOfId, orderRepository.findById(orderID).get(), quantity));

    }
}
