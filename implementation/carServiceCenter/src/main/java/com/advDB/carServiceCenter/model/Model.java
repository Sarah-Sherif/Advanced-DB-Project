package com.advDB.carServiceCenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "model")
public class Model {
    @EmbeddedId
    private ModelId modelId;

    @Column(name = "brand")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String brand;
}