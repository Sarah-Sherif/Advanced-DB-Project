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
@Table(name = "consist_of", schema = "carservicecenter", indexes = {
        @Index(name = "Component_Model", columnList = "Component_Model")
})
public class ConsistOf {
    @EmbeddedId
    private ConsistOfId id;

    @MapsId("orderId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Order_ID", nullable = false)
    private Order order;

    @Column(name = "Quantity", columnDefinition = "smallint UNSIGNED not null")
    private Integer quantity;

}