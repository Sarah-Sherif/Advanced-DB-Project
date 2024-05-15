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
@Table(name = "general_order")
@Inheritance(strategy = InheritanceType.JOINED)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer orderId;

    @Column(name = "status")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String status;

    @Column(name = "payment_method")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String paymentMethod;

    @Column(name = "date")
    @JdbcTypeCode(SqlTypes.DATE)
    private String date;

}