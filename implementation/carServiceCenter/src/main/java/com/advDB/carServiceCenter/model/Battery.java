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
public class Battery extends Component {
    @Column(name = "expiry_date")
    @JdbcTypeCode(SqlTypes.DATE)
    private String expiryDate;

    public Battery(String model, String expiryDate, Double price) {
        super(model, price);
        this.expiryDate = expiryDate;
    }
}