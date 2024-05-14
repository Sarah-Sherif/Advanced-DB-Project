package com.nuggets.advDB.service;

import java.time.LocalDate;

public interface RepairOrderService {

    void insertRepairOrder(String status, String paymentMethod, LocalDate date,
                           String customerSSN, String city, Integer streetNo, Long buildingNo, String district);

    void updateRepairOrderTotalCost(Long orderID, Double totalCost);

}

