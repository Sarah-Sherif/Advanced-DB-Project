package com.nuggets.advDB.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "person_phone_no", schema = "carservicecenter")
public class PersonPhoneNo {
    @EmbeddedId
    private PersonPhoneNoId id;

    @MapsId("ssn")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "SSN", nullable = false)
    private Person ssn;

}