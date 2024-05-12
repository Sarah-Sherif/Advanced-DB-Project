package com.nuggets.advDB.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "performs", schema = "carservicecenter", indexes = {
        @Index(name = "Task_ID", columnList = "Task_ID")
})
public class Perform {
    @EmbeddedId
    private PerformId id;

    @MapsId("ssn")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "SSN", nullable = false)
    private Engineer ssn;

    @MapsId("taskId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Task_ID", nullable = false)
    private MaintenanceTask task;

}