package com.nuggets.advDB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
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

    @Column(name = "Total_Cost")
    private Double totalCost;

}