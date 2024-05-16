package com.advDB.carServiceCenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SalesMan extends Employee {
    @Column(name = "sales_made")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private String salesMade;

    public SalesMan(Long ssn, String firstName, String middleName, String lastName, LocalDate birthdate, String phoneNo, String email, Double salary, ServiceCenter serviceCenter) {
        super(ssn, firstName, middleName, lastName, birthdate, phoneNo, email, salary, serviceCenter, "SalesMan");
    }
}