package com.advDB.carServiceCenter.service.impl;

import com.advDB.carServiceCenter.model.PurchaseOrder;
import com.advDB.carServiceCenter.model.repositories.PurchaseOrderRepository;
import com.advDB.carServiceCenter.model.repositories.SupplierRepository;
import com.advDB.carServiceCenter.service.OrderService;
import com.advDB.carServiceCenter.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private final PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private final OrderService orderService;

    @Autowired
    private final SupplierRepository supplierRepository;

    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository, OrderService orderService, SupplierRepository supplierRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.orderService = orderService;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void insertPurchaseOrder(String status, String paymentMethod, String date, String deliverDate, String supplierSSN) {
        orderService.insertOrder(status, paymentMethod, date);
        purchaseOrderRepository.save(new PurchaseOrder(status, paymentMethod, date, deliverDate, supplierRepository.findBySsn(Long.valueOf(supplierSSN)).get()));
    }
}
