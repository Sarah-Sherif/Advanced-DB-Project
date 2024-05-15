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
@Table(name = "maintenance_task", indexes = {
        @Index(name = "idx_maintenancetask", columnList = "service_center_id, repair_order_id")
})
public class MaintenanceTask {
    @Id
    @Column(name = "task_id", nullable = false)
    private String taskId;

    @Column(name = "task_date")
    @JdbcTypeCode(SqlTypes.DATE)
    private String taskDate;

    @Column(name = "price")
    @JdbcTypeCode(SqlTypes.FLOAT)
    private String price;

    @ManyToMany(mappedBy = "maintenanceTasks")
    private Set<Engineer> engineers = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "service_center_id")
    private ServiceCenter serviceCenter;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_plate_no", nullable = false)
    private Car car;

    @ManyToOne(optional = false)
    @JoinColumn(name = "component_model", nullable = false)
    private Component component;

    @ManyToOne(optional = false)
    @JoinColumn(name = "repair_order_id", nullable = false)
    private RepairOrder repairOrder;

}