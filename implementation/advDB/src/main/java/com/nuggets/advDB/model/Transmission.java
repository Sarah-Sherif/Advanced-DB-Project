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
@Table(name = "transmission", schema = "carservicecenter")
public class Transmission {
    @Id
    @Size(max = 50)
    @Column(name = "Model", nullable = false, length = 50)
    private String model;

    @NotNull
    @Lob
    @Column(name = "Transmission_Type", nullable = false)
    private String transmissionType;

}