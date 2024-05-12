package com.nuggets.advDB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@MappedSuperclass
@Table(name = "component", schema = "carservicecenter")
public class Component {
    @Id
    @Size(max = 50)
    @Column(name = "Model", nullable = false, length = 50)
    private String model;

    @Column(name = "Price", columnDefinition = "float(0, 0) UNSIGNED not null")
    private Double price;

    @OneToOne(mappedBy = "component")
    private Battery battery;

    @OneToOne(mappedBy = "component")
    private Body body;

    @OneToMany(mappedBy = "component")
    private Set<ConsistOf> consistOfs = new LinkedHashSet<>();

    @OneToOne(mappedBy = "component")
    private Engine engine;

    @OneToMany(mappedBy = "componentModel")
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "component")
    private Set<Supplier> suppliers = new LinkedHashSet<>();

    @OneToOne(mappedBy = "component")
    private Transmission transmission;

}