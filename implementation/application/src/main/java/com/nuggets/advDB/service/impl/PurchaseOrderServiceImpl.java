package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Order;
import com.nuggets.advDB.model.PurchaseOrder;
import com.nuggets.advDB.model.repository.PurchaseOrderRepository;
import com.nuggets.advDB.model.repository.SupplierRepository;
import com.nuggets.advDB.service.OrderService;
import com.nuggets.advDB.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
    public void insertPurchaseOrder(String status, String paymentMethod, LocalDate date, LocalDate deliveryDate, String supplierSSN) {
        orderService.insertOrder(status, paymentMethod, date);
        Order order = new Order(status, paymentMethod, date);
        purchaseOrderRepository.save(new PurchaseOrder(order, deliveryDate, supplierRepository.findBySSsn(supplierSSN).get()));
    }
}
