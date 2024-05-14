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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "engine", schema = "carservicecenter")
public class Engine {
    @Id
    @Size(max = 50)
    @Column(name = "Model", nullable = false, length = 50)
    private String model;

    @Size(max = 14)
    @NotNull
    @Column(name = "Lubricant_Type", nullable = false, length = 14)
    private String lubricantType;

    @Column(name = "Horse_Power", columnDefinition = "smallint UNSIGNED not null")
    private Integer horsePower;

}