package com.nuggets.advDB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "car", schema = "carservicecenter", indexes = {
        @Index(name = "Model_Name", columnList = "Model_Name"),
        @Index(name = "Model_Year", columnList = "Model_Year"),
        @Index(name = "SSN", columnList = "SSN")
})
public class Car {
    @Id
    @Size(max = 10)
    @Column(name = "Plate_NO", nullable = false, length = 10)
    private String plateNo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Model_Name", nullable = false, referencedColumnName = "Model_Name")
    private Model modelName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Model_Year", nullable = false, referencedColumnName = "Model_Year")
    private Model modelYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "SSN")
    private Customer ssn;

    @OneToMany(mappedBy = "plateNo")
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

}