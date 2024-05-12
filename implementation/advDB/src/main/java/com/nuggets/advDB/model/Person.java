package com.nuggets.advDB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "person", schema = "carservicecenter")
@MappedSuperclass
public class Person {
    @Id
    @Size(max = 14)
    @Column(name = "SSN", nullable = false, length = 14)
    private String ssn;

    @Column(name = "Birthdate")
    private LocalDate birthdate;

    @Size(max = 50)
    @Column(name = "Email", length = 50)
    private String email;

    @Size(max = 50)
    @NotNull
    @Column(name = "First_Name", nullable = false, length = 50)
    private String firstName;

    @Size(max = 50)
    @Column(name = "Middle_Name", length = 50)
    private String middleName;

    @Size(max = 50)
    @NotNull
    @Column(name = "Last_Name", nullable = false, length = 50)
    private String lastName;

    @OneToOne(mappedBy = "person")
    private Customer customer;

    @OneToOne(mappedBy = "person")
    private Employee employee;

    @OneToMany(mappedBy = "person")
    private Set<PersonPhoneNo> personPhoneNos = new LinkedHashSet<>();

    @OneToOne(mappedBy = "person")
    private Supplier supplier;

}