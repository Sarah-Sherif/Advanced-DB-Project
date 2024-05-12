package com.nuggets.advDB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@MappedSuperclass
@Table(name = "`order`", schema = "carservicecenter")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_ID", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Lob
    @Column(name = "Status")
    private String status;

    @NotNull
    @Lob
    @Column(name = "Payment_Method", nullable = false)
    private String paymentMethod;

    @NotNull
    @Column(name = "Date", nullable = false)
    private LocalDate date;

    @OneToMany(mappedBy = "order")
    private Set<ConsistOf> consistOfs = new LinkedHashSet<>();

    @OneToOne(mappedBy = "order")
    private PurchaseOrder purchaseOrder;
    @OneToOne(mappedBy = "order")
    private RepairOrder repairOrder;

    @Column(name = "Total_Cost", columnDefinition = "float(0, 0) UNSIGNED")
    private double totalCost;
}