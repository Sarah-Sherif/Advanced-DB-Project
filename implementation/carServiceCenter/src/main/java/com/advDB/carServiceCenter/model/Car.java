package com.advDB.carServiceCenter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "car", indexes = {
        @Index(name = "idx_car_customer_ssn", columnList = "customer_ssn, MODEL_NAME, MODEL_YEAR")
})
public class Car {
    @Id
    @Column(name = "plate_no", nullable = false)
    private String plateNo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_ssn", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "car", orphanRemoval = true)
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "model_name", referencedColumnName = "modelName", nullable = false),
            @JoinColumn(name = "model_year", referencedColumnName = "modelYear", nullable = false)
    })
    private Model model;

}