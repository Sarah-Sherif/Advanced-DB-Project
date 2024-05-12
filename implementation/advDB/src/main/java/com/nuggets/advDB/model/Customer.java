package com.nuggets.advDB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Customer extends Person {

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

    @OneToMany(mappedBy = "ssn")
    private Set<Car> cars = new LinkedHashSet<>();

    @OneToMany(mappedBy = "cSsn")
    private Set<RepairOrder> repairOrders = new LinkedHashSet<>();

}