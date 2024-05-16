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
        @Index(name = "idx_maintenancetask", columnList = "center_id, repair_order_id")
})
public class MaintenanceTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", nullable = false)
    private Integer taskId;

    @Column(name = "task_date")
    @JdbcTypeCode(SqlTypes.DATE)
    private String taskDate;

    @Column(name = "price")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double price;

    @ManyToMany(mappedBy = "maintenanceTasks")
    private Set<Engineer> engineers = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "center_id")
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

    public MaintenanceTask(String taskDate, Double price, ServiceCenter serviceCenter, Car car, RepairOrder repairOrder, Component component) {
        this.taskDate = taskDate;
        this.price = price;
        this.serviceCenter = serviceCenter;
        this.car = car;
        this.repairOrder = repairOrder;
        this.component = component;
    }
}