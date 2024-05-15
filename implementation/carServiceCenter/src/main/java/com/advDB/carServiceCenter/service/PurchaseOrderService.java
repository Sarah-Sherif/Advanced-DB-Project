package com.advDB.carServiceCenter.service;

public interface PurchaseOrderService {

    void insertPurchaseOrder(String status, String paymentMethod, String date, String deliverDate, String supplierSSN);
}
