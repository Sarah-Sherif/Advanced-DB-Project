package com.nuggets.advDB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "purchase_order", schema = "carservicecenter", indexes = {
        @Index(name = "S_SSN", columnList = "S_SSN")
})
public class PurchaseOrder {
    @Id
    @Column(name = "Order_ID", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Order_ID", nullable = false)
    private Order order;

    @NotNull
    @Column(name = "Delivery_Date", nullable = false)
    private LocalDate deliveryDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "S_SSN", nullable = false)
    private Supplier supplier;

}