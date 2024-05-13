package com.nuggets.advDB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sales_man", schema = "carservicecenter")
public class SalesMan {
    @Id
    @Size(max = 14)
    @Column(name = "SM_SSN", nullable = false, length = 14)
    private String smSsn;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "SM_SSN", nullable = false)
    private Employee employee;

    @Column(name = "Sales_Made", columnDefinition = "int UNSIGNED")
    private Long salesMade;

}