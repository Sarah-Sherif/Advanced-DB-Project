package com.nuggets.advDB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Battery extends Component {

    @NotNull
    @Column(name = "Expiry_Date", nullable = false)
    private LocalDate expiryDate;

}