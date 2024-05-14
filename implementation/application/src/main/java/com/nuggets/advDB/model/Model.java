package com.nuggets.advDB.model;

import jakarta.persistence.*;
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

}