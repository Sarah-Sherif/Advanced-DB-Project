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
@Table(name = "component", schema = "carservicecenter")
public class Component {
    @Id
    @Size(max = 50)
    @Column(name = "Model", nullable = false, length = 50)
    private String model;

    @NotNull
    @Column(name = "Price", nullable = false)
    private Double price;

}