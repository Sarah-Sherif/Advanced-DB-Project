package com.advDB.carServiceCenter.model;

import jakarta.persistence.*;
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
@Table(name = "component")
@Inheritance(strategy = InheritanceType.JOINED)
public class Component {
    @Id
    @Column(name = "component_model", nullable = false)
    private String componentModel;

    @Column(name = "price")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double price;

    @ManyToMany(mappedBy = "componentsOffered")
    private Set<Supplier> suppliers = new LinkedHashSet<>();

    public Component(String model, Double price) {
        this.componentModel = model;
        this.price = price;
    }
}