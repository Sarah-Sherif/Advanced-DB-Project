package com.advDB.carServiceCenter.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "plate_no", nullable = false)
    private String plateNo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_ssn", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "car", orphanRemoval = true)
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

}