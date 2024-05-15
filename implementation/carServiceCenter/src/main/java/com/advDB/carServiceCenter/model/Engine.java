package com.advDB.carServiceCenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
public class Engine extends Component {
    @Column(name = "lubricant_type")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String lubricantType;

    @Column(name = "horse_power")
    @JdbcTypeCode(SqlTypes.FLOAT)
    private String horsePower;
}