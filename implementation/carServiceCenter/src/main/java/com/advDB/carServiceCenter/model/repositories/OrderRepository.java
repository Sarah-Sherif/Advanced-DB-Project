package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}