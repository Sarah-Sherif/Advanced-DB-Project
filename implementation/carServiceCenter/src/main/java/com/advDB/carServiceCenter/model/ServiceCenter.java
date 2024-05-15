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
@Table(name = "service_center")
public class ServiceCenter {
    @Id
    @Column(name = "center_id", nullable = false)
    private String centerID;

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

    @OneToMany(mappedBy = "serviceCenter", orphanRemoval = true)
    private Set<Employee> employees = new LinkedHashSet<>();

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "manager_ssn", nullable = false)
    private Employee manager;

    @OneToMany(mappedBy = "serviceCenter", orphanRemoval = true)
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

}