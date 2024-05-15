package com.advDB.carServiceCenter.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "general_order")
@Inheritance(strategy = InheritanceType.JOINED)
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "status")
    @JdbcTypeCode(SqlTypes.BOOLEAN)
    private String status;

    @Column(name = "payment_method")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String paymentMethod;

    @Column(name = "date")
    @JdbcTypeCode(SqlTypes.DATE)
    private String date;

}