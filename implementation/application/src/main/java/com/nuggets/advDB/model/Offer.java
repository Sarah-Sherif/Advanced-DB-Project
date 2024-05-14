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
@Table(name = "offers", schema = "carservicecenter", indexes = {
        @Index(name = "S_SSN", columnList = "S_SSN")
})
public class Offer {
    @EmbeddedId
    private OfferId id;

    @MapsId("sSsn")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "S_SSN", nullable = false)
    private Supplier sSsn;

}