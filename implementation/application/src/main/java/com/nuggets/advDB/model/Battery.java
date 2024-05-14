package com.nuggets.advDB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "battery", schema = "carservicecenter")
public class Battery {
    @Id
    @Size(max = 50)
    @Column(name = "Model", nullable = false, length = 50)
    private String model;

    @NotNull
    @Column(name = "Expiry_Date", nullable = false)
    private LocalDate expiryDate;

}