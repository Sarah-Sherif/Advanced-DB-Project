package com.nuggets.advDB.service;

import java.time.LocalDate;

public interface PurchaseOrderService {
    /*
    INSERT INTO `Purchase_Order`(`Order_ID`, `Delivery_Date`, `S_SSN`)
VALUES  (7, '2023-05-10', '70101432805243'),
        (8, '2023-05-11', '96102103500871'),
        (9, '2023-05-12', '91052603700351'),
        (10, '2023-05-13', '29304152804122'),
        (11, '2023-05-12', '70101432805243'),
		(12, '2023-05-11', '96102103500871'),
		(13, '2023-05-10', '91052603700351'),
		(14, '2023-05-09', '29304152804122'),
		(15, '2023-05-16', '70101432805243'),
		(16, '2023-05-15', '96102103500871'),
		(17, '2023-05-14', '91052603700351'),
		(18, '2023-05-13', '29304152804122');
     */

//    void insertPurchaseOrder(Long orderID, LocalDate deliveryDate, String supplierSSN);

        void insertPurchaseOrder(String status, String paymentMethod, LocalDate date,
                                LocalDate deliveryDate, String supplierSSN);
}
