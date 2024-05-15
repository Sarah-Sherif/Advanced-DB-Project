package com.advDB.carServiceCenter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "purchase_order_components",
            joinColumns = @JoinColumn(name = "purchase_order_id"),
            inverseJoinColumns = @JoinColumn(name = "component_model"))
    private Set<Component> components = new LinkedHashSet<>();

}