package com.nuggets.advDB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "customer_details", schema = "carservicecenter")
public class CustomerDetail {
    @Id
    @Size(max = 14)
    @NotNull
    @Column(name = "SSN", nullable = false, length = 14)
    private String ssn;

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

    @Size(max = 20)
    @NotNull
    @Column(name = "City", nullable = false, length = 20)
    private String city;

    @Column(name = "Street_NO", columnDefinition = "smallint UNSIGNED not null")
    private Integer streetNo;

    @Column(name = "Building_NO", columnDefinition = "int UNSIGNED not null")
    private Long buildingNo;

    @Size(max = 20)
    @NotNull
    @Column(name = "District", nullable = false, length = 20)
    private String district;

}