package com.nuggets.advDB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Engineer extends Employee{

    @Size(max = 50)
    @Column(name = "Specialization", length = 50)
    private String specialization;

    @ManyToMany(mappedBy = "engineer")
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

}