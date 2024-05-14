package com.nuggets.advDB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class ConsistOfId implements Serializable {
    private static final long serialVersionUID = 9109236138278742364L;
    @Column(name = "Order_ID", columnDefinition = "int UNSIGNED not null")
    private Long orderId;

    @Size(max = 50)
    @NotNull
    @Column(name = "Component_Model", nullable = false, length = 50)
    private String componentModel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ConsistOfId entity = (ConsistOfId) o;
        return Objects.equals(this.componentModel, entity.componentModel) &&
                Objects.equals(this.orderId, entity.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentModel, orderId);
    }

}