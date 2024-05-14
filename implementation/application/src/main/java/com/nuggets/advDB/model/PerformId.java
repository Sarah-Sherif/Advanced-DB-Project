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
public class PerformId implements Serializable {
    private static final long serialVersionUID = -7182910180953609155L;
    @Size(max = 14)
    @NotNull
    @Column(name = "SSN", nullable = false, length = 14)
    private String ssn;

    @Column(name = "Task_ID", columnDefinition = "int UNSIGNED not null")
    private Long taskId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PerformId entity = (PerformId) o;
        return Objects.equals(this.taskId, entity.taskId) &&
                Objects.equals(this.ssn, entity.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, ssn);
    }

}