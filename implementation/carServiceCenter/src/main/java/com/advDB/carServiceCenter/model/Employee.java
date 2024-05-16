package com.advDB.carServiceCenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Employee", indexes = {
        @Index(name = "idx_employee", columnList = "center_id")
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee extends Person {
    @Column(name = "role")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String role;

    @Column(name = "salary")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double salary;

    @ManyToOne(optional = false)
    @JoinColumn(name = "center_id", nullable = false)
    private ServiceCenter serviceCenter;

    public Employee(Long ssn, String firstName, String middleName, String lastName, String birthdate, String phoneNo, String email, Double salary, ServiceCenter serviceCenter, String role) {
        super(ssn, firstName, middleName, lastName, birthdate, phoneNo, email);
        this.setServiceCenter(serviceCenter);
        this.setSalary(salary);
        this.setRole(role);
    }
}