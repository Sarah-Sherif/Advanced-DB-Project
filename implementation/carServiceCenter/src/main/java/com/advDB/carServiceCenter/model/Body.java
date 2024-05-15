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
public class Body extends Component {
    @Column(name = "chassis_type")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String chassisType;
}