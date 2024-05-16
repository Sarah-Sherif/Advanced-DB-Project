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
@Table(name = "service_center", indexes = {
        @Index(name = "idx_servicecenter_manager_ssn", columnList = "manager_ssn")
})
public class ServiceCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "center_id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer centerID;

    @Column(name = "city")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String city;

    @Column(name = "district")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String district;

    @Column(name = "street_no")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer streetNo;

    @Column(name = "building_no")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer buildingNo;

    @OneToMany(mappedBy = "serviceCenter", orphanRemoval = true)
    private Set<Employee> employees = new LinkedHashSet<>();

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "manager_ssn", nullable = false)
    private Employee manager;

    @OneToMany(mappedBy = "serviceCenter", orphanRemoval = true)
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

    public ServiceCenter(String city, String district, Integer streetNo, Integer buildingNo, Employee employee) {
        this.city = city;
        this.district = district;
        this.streetNo = streetNo;
        this.buildingNo = buildingNo;
        this.manager = employee;
        this.employees.add(employee);
    }
}