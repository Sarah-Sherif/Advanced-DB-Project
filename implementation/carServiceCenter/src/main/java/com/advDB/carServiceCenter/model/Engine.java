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
public class Engine extends Component {
    @Column(name = "lubricant_type")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String lubricantType;

    @Column(name = "horse_power")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer horsePower;

    public Engine(String model, String lubricantType, int horsePower, Double price){
        super(model, price);
        this.setLubricantType(lubricantType);
        this.setHorsePower(horsePower);
    }
}