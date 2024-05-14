package com.nuggets.advDB.service;

import java.time.LocalDate;

public interface RepairOrderService {
    /*
    INSERT INTO `Repair_Order`(`Order_ID`, `C_SSN`, `City`, `Street_NO`, `Building_NO`, `District`)
VALUES
		(1, '97010701700418', 'Cairo', 23, 5, 'Maadi'),
		(2, '88061701300306', 'Alexandria', 16, 8, 'Gleem'),
		(3, '91052101500785', 'Giza', 7, 12, 'Mohandeseen'),
		(4, '24703082706851', 'Giza', 15, 45, 'El Mohandessin'),
		(5, '28801032905237','Alexandria', 10, 23, 'Sidi Gaber'),
        (6, '78701252907252', 'Cairo', 5, 12, 'Nasr City');
     */

//    void insertRepairOrder(Long orderID, String customerSSN, String city, Integer streetNo, Long buildingNo, String district);

    void insertRepairOrder(String status, String paymentMethod, LocalDate date,
                           String customerSSN, String city, Integer streetNo, Long buildingNo, String district);

}

