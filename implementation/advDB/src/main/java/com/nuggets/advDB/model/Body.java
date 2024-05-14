package com.nuggets.advDB.model;

import jakarta.persistence.*;
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
@Table(name = "body", schema = "carservicecenter")
public class Body {
    @Id
    @Size(max = 50)
    @Column(name = "Model", nullable = false, length = 50)
    private String model;

    @Lob
    @Column(name = "Chassis_Type")
    private String chassisType;

    public Body(String model) {
        this.model = model;
    }
}