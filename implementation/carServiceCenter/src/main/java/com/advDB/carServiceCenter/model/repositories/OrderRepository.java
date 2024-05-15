package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findByOrderId(Integer orderId);
}