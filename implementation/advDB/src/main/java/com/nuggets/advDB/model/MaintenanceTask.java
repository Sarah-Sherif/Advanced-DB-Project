package com.nuggets.advDB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "maintenance_task", schema = "carservicecenter", indexes = {
        @Index(name = "Center_ID", columnList = "Center_ID"),
        @Index(name = "Plate_NO", columnList = "Plate_NO"),
        @Index(name = "Order_ID", columnList = "Order_ID"),
        @Index(name = "Component_Model", columnList = "Component_Model")
})
public class MaintenanceTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Task_ID", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @NotNull
    @Column(name = "Task_Date", nullable = false)
    private LocalDate taskDate;

    @NotNull
    @Column(name = "Price", nullable = false)
    private Double price;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Center_ID", nullable = false)
    private ServiceCenter center;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Plate_NO", nullable = false)
    private Car plateNo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Order_ID", nullable = false)
    private RepairOrder order;

    @ManyToMany(mappedBy = "maintenanceTasks")
    private Set<Engineer> engineers = new LinkedHashSet<>();

}