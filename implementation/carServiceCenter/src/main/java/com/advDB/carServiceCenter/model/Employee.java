package com.advDB.carServiceCenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee extends Person {
    @Column(name = "role")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String role;

    @Column(name = "salary")
    @JdbcTypeCode(SqlTypes.FLOAT)
    private String salary;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_center_id", nullable = false)
    private ServiceCenter serviceCenter;

}