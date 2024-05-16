package com.advDB.carServiceCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    @JsonIgnore
    @JoinColumn(name = "center_id", nullable = false)
    private ServiceCenter serviceCenter;

    public Employee(Long ssn, String firstName, String middleName, String lastName, LocalDate birthdate, String phoneNo, String email, Double salary, ServiceCenter serviceCenter, String role) {
        super(ssn, firstName, middleName, lastName, birthdate, phoneNo, email);
        this.setServiceCenter(serviceCenter);
        this.setSalary(salary);
        this.setRole(role);
    }
}