package com.advDB.carServiceCenter.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class RepairOrder extends Order {
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_ssn", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "repairOrder", orphanRemoval = true)
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

}