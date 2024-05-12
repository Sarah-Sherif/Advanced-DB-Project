package com.nuggets.advDB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "service_center_summary", schema = "carservicecenter")
public class ServiceCenterSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Center_ID", columnDefinition = "int UNSIGNED not null")
    private Long centerId;

    @NotNull
    @Column(name = "No_of_Employees", nullable = false)
    private Long noOfEmployees;

    @Column(name = "Avg_Salary")
    private Double avgSalary;

    @Column(name = "Total_Salary")
    private Double totalSalary;

}