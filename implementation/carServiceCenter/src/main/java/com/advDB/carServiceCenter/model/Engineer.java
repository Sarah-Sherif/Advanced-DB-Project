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
public class Engineer extends Employee {
    @Column(name = "specialization")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String specialization;

    @ManyToMany
    @JoinTable(name = "engineers_maintenance_tasks",
            joinColumns = @JoinColumn(name = "engineer_ssn"),
            inverseJoinColumns = @JoinColumn(name = "maintenance_task_id"))
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

}