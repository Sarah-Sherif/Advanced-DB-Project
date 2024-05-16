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
@Table(name = "RepairOrder", indexes = {
        @Index(name = "idx_repairorder_customer_ssn", columnList = "customer_ssn")
})
public class RepairOrder extends Order {
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_ssn", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "repairOrder", orphanRemoval = true)
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

    public RepairOrder(String city, String district, Integer buildingNo, Customer customer, MaintenanceTask maintenanceTask) {
        super();
        this.city = city;
        this.district = district;
        this.buildingNo = buildingNo;
        this.customer = customer;
        this.maintenanceTasks.add(maintenanceTask);
    }
}