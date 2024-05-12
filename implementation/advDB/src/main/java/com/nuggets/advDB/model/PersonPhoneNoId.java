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
public class PersonPhoneNoId implements Serializable {
    private static final long serialVersionUID = -8899235374506095240L;
    @Size(max = 14)
    @NotNull
    @Column(name = "SSN", nullable = false, length = 14)
    private String ssn;

    @Size(max = 11)
    @NotNull
    @Column(name = "Phone_NO", nullable = false, length = 11)
    private String phoneNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonPhoneNoId entity = (PersonPhoneNoId) o;
        return Objects.equals(this.phoneNo, entity.phoneNo) &&
                Objects.equals(this.ssn, entity.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNo, ssn);
    }

}