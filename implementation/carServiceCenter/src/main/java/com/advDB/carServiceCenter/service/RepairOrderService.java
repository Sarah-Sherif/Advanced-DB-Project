package com.advDB.carServiceCenter.service;

import java.time.LocalDate;

public interface RepairOrderService {

    void insertRepairOrder(String status, String paymentMethod, LocalDate date,
                           String customerSSN, String city, Integer streetNo, Long buildingNo, String district);
}
