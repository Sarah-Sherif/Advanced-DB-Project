package com.advDB.carServiceCenter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PurchaseOrder", indexes = {
        @Index(name = "idx_purchaseorder", columnList = "supplier_ssn")
})
public class PurchaseOrder extends Order {
    @Column(name = "deliver_date")
    @JdbcTypeCode(SqlTypes.DATE)
    private String deliverDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "supplier_ssn", nullable = false)
    private Supplier supplier;

}