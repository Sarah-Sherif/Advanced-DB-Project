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

public class RepairOrder extends Order {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "C_SSN", nullable = false)
    private Customer cSsn;

    @Size(max = 20)
    @NotNull
    @Column(name = "City", nullable = false, length = 20)
    private String city;

    @Column(name = "Street_NO", columnDefinition = "smallint UNSIGNED not null")
    private Integer streetNo;

    @Column(name = "Building_NO", columnDefinition = "int UNSIGNED not null")
    private Long buildingNo;

    @Size(max = 20)
    @NotNull
    @Column(name = "District", nullable = false, length = 20)
    private String district;

    @OneToMany(mappedBy = "order")
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

}