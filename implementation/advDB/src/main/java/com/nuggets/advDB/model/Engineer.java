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
@Table(name = "engineer", schema = "carservicecenter")
public class Engineer {
    @Id
    @Size(max = 14)
    @Column(name = "E_SSN", nullable = false, length = 14)
    private String eSsn;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "E_SSN", nullable = false)
    private Employee employee;

    @Size(max = 50)
    @Column(name = "Specialization", length = 50)
    private String specialization;

    @ManyToMany
    @JoinTable(name = "performs",
            joinColumns = @JoinColumn(name = "SSN"),
            inverseJoinColumns = @JoinColumn(name = "Task_ID"))
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

}