package com.advDB.carServiceCenter.model;

import jakarta.persistence.*;
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
@Table(name = "model", indexes = {
        @Index(name = "idx_model_model_name", columnList = "model_name, model_year")
})
public class Model {
    @EmbeddedId
    private ModelId modelId;

    @Column(name = "brand")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String brand;
}