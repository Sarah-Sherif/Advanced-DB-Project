package com.advDB.carServiceCenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Transmission extends Component {
    @Column(name = "transmission_type")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String transmissionType;

    public Transmission(String model, String transmissionType, Double price) {
        super(model, price);
        this.setTransmissionType(transmissionType);
    }
}