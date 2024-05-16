package com.advDB.carServiceCenter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Supplier extends Person {
    @Column(name = "website")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String website;

    @ManyToMany
    @JoinTable(name = "supplier_components_offered",
            joinColumns = @JoinColumn(name = "ssn"),
            inverseJoinColumns = @JoinColumn(name = "component_model"))
    private Set<Component> componentsOffered = new LinkedHashSet<>();

    @OneToMany(mappedBy = "supplier", orphanRemoval = true)
    private Set<PurchaseOrder> purchaseOrders = new LinkedHashSet<>();

    public Supplier(Long ssn, String firstName, String middleName, String lastName, LocalDate birthDate, String email, String website, String phoneNo) {
        super(ssn, firstName, middleName, lastName, birthDate, email, phoneNo);
    }
}