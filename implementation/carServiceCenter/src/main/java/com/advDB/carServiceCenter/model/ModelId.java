package com.advDB.carServiceCenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class ModelId implements Serializable {
    private String modelName;
    @Column(nullable = false)
    private int modelYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ModelId entity = (ModelId) o;
        return Objects.equals(this.modelName, entity.modelName) &&
                Objects.equals(this.modelYear, entity.modelYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, modelYear);
    }
}