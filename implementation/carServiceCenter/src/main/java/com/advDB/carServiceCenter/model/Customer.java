package com.advDB.carServiceCenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class Customer extends Person {
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

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private Set<Car> cars = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private Set<RepairOrder> repairOrders = new LinkedHashSet<>();

    public Customer(Long ssn, String city, Integer streetNo, Integer buildingNo, String district, String firstName, String middleName, String lastName, String birthDate, String phoneNo, String email) {
        super(ssn, firstName, middleName, lastName, birthDate, phoneNo, email);
        this.city = city;
        this.streetNo = streetNo;
        this.buildingNo = buildingNo;
        this.district = district;
    }

}