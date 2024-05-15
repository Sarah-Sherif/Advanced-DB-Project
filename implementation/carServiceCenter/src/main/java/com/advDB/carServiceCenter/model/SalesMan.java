package com.advDB.carServiceCenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
public class SalesMan extends Employee {
    @Column(name = "sales_made")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private String salesMade;
}