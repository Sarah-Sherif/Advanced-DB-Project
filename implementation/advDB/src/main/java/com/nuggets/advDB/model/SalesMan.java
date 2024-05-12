package com.nuggets.advDB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SalesMan extends Employee{

    @Column(name = "Sales_Made", columnDefinition = "int UNSIGNED")
    private Long salesMade;

}