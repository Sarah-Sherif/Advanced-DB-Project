package com.advDB.carServiceCenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Customer extends Person {
    @Column(name = "city")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String city;

    @Column(name = "district")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String district;

    @Column(name = "street_no")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private String streetNo;

    @Column(name = "building_no")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private String buildingNo;

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private Set<Car> cars = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private Set<RepairOrder> repairOrders = new LinkedHashSet<>();

}