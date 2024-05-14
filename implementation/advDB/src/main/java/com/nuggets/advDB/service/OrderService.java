package com.nuggets.advDB.service;

import java.time.LocalDate;

public interface OrderService {

    void insertOrder(String status, String paymentMethod, LocalDate date);
}
