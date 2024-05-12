package com.nuggets.advDB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "model", schema = "carservicecenter", indexes = {
        @Index(name = "Model_Name", columnList = "Model_Name"),
        @Index(name = "Model_Year", columnList = "Model_Year")
})
public class Model {
    @EmbeddedId
    private ModelId id;

    @Size(max = 10)
    @NotNull
    @Column(name = "Brand", nullable = false, length = 10)
    private String brand;

    @OneToMany(mappedBy = "modelName")
    private Set<Car> cars = new LinkedHashSet<>();

}