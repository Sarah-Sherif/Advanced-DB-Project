package com.nuggets.advDB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class OfferId implements Serializable {
    private static final long serialVersionUID = 2365135061918116631L;
    @Size(max = 50)
    @NotNull
    @Column(name = "Component_Model", nullable = false, length = 50)
    private String componentModel;

    @Size(max = 14)
    @NotNull
    @Column(name = "S_SSN", nullable = false, length = 14)
    private String sSsn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OfferId entity = (OfferId) o;
        return Objects.equals(this.componentModel, entity.componentModel) &&
                Objects.equals(this.sSsn, entity.sSsn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentModel, sSsn);
    }

}