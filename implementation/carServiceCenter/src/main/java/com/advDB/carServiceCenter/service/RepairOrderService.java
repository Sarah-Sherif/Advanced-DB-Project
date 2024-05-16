package com.advDB.carServiceCenter.service;

public interface RepairOrderService {

    void insertRepairOrder(String status, String paymentMethod, String date,
                           String customerSSN, String city, Integer streetNo, Integer buildingNo, String district, String taskId);

}
