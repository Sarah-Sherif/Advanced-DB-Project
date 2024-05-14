package com.nuggets.advDB.model;

import jakarta.persistence.*;
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
@Table(name = "supplier", schema = "carservicecenter")
public class Supplier {
    @Id
    @Size(max = 14)
    @Column(name = "S_SSN", nullable = false, length = 14)
    private String sSsn;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "S_SSN", nullable = false)
    private Person person;

    @Size(max = 255)
    @Column(name = "Website")
    private String website;

    @OneToMany(mappedBy = "sSsn")
    private Set<PurchaseOrder> purchaseOrders = new LinkedHashSet<>();

    public Supplier(String ssn, Person person, String website) {
        this.sSsn = ssn;
        this.person = person;
        this.website = website;
    }
}