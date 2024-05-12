package com.nuggets.advDB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Transmission extends Component {

    @NotNull
    @Lob
    @Column(name = "Transmission_Type", nullable = false)
    private String transmissionType;

}