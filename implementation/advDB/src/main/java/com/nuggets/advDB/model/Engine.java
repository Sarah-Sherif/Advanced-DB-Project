package com.nuggets.advDB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Engine extends Component{

    @Size(max = 14)
    @NotNull
    @Column(name = "Lubricant_Type", nullable = false, length = 14)
    private String lubricantType;

    @Column(name = "Horse_Power", columnDefinition = "smallint UNSIGNED not null")
    private Integer horsePower;

}