package com.advDB.carServiceCenter.service;

public interface OrderService {

    void insertOrder(String status, String paymentMethod, String date);
}
