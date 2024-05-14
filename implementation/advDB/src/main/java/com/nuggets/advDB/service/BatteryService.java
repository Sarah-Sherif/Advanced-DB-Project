package com.nuggets.advDB.service;

import java.time.LocalDate;

public interface BatteryService {

    void insertBattery(String model, LocalDate expiryDate);
}
