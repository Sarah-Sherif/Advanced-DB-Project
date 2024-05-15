package com.advDB.carServiceCenter.service;

public interface MaintenanceTaskService {

    void insertMaintenanceTask(String taskDate, Double price, Long centerID, String plateNO, Long orderID, String componentModel);

}
