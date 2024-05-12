package com.nuggets.advDB.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "offers", schema = "carservicecenter", indexes = {
        @Index(name = "S_SSN", columnList = "S_SSN")
})
public class Offer {
    @EmbeddedId
    private OfferId id;

    @MapsId("componentModel")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Component_Model", nullable = false)
    private Component componentModel;

    @MapsId("sSsn")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "S_SSN", nullable = false)
    private Supplier sSsn;

}