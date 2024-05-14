package com.nuggets.advDB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer", schema = "carservicecenter")
public class Customer {
    @Id
    @Size(max = 14)
    @Column(name = "C_SSN", nullable = false, length = 14)
    private String cSsn;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "C_SSN", nullable = false)
    private Person person;

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

    @OneToMany(mappedBy = "customer")
    private Set<Car> cars = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<RepairOrder> repairOrders = new LinkedHashSet<>();

    public Customer(String ssn, String city, Integer streetNo, Long buildingNo, String district) {
//        implement the constructor
        this.cSsn = ssn;
        this.city = city;
        this.streetNo = streetNo;
        this.buildingNo = buildingNo;
        this.district = district;
    }
}