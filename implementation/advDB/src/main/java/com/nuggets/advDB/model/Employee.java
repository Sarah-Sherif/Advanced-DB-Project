package com.nuggets.advDB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@MappedSuperclass
public class Employee extends Person{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Center_ID", nullable = false)
    private ServiceCenter center;

    @NotNull
    @Lob
    @Column(name = "Role", nullable = false)
    private String role;

    @OneToOne(mappedBy = "employee")
    private Engineer engineer;

    @OneToOne(mappedBy = "employee")
    private SalesMan salesMan;
    @OneToMany(mappedBy = "mSsn")
    private Set<ServiceCenter> serviceCenters = new LinkedHashSet<>();


    @Column(name = "Salary", columnDefinition = "float(0, 0) UNSIGNED not null")
    private double salary;

}