package com.nuggets.advDB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Supplier extends Person{

    @Size(max = 255)
    @Column(name = "Website")
    private String website;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Component> components = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sSsn")
    private Set<PurchaseOrder> purchaseOrders = new LinkedHashSet<>();

}