package com.lumo.core.Entities;

import com.lumo.core.ENUM.WorkflowStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class WorkflowEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(nullable = false)
    private String name;

    @Column
    @Enumerated(value = EnumType.STRING)
    public WorkflowStatus status = WorkflowStatus.INITIAL;

    //TODO: add trigger and actions

    // as of now we have only 1 trigger per workflow
    @OneToMany(mappedBy = "workflow")
    private List<TriggerEntity> triggers;

}
