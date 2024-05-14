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
@Table(name = "employee", schema = "carservicecenter", indexes = {
        @Index(name = "Center_ID", columnList = "Center_ID")
})
public class Employee {
    @Id
    @Size(max = 14)
    @Column(name = "E_SSN", nullable = false, length = 14)
    private String eSsn;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "E_SSN", nullable = false)
    private Person person;

    @NotNull
    @Column(name = "Salary", nullable = false)
    private Double salary;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Center_ID", nullable = false)
    private ServiceCenter center;

    @NotNull
    @Lob
    @Column(name = "Role", nullable = false)
    private String role;

    @OneToMany(mappedBy = "manager")
    private Set<ServiceCenter> serviceCenter = new LinkedHashSet<>();

    public Employee(String ssn, Person person, Double salary, ServiceCenter center, String role) {
        this.eSsn = ssn;
        this.person = person;
        this.salary = salary;
        this.center = center;
        this.role = role;
    }
}