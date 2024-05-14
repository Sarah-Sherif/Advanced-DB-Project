package com.nuggets.advDB.service;

import java.time.LocalDate;

public interface MaintenanceTaskService {

    void insertMaintenanceTask(LocalDate taskDate, Double price, Long centerID, String plateNO, Long orderID, String componentModel);
}
