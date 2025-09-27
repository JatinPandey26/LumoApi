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

    @Column
    @OneToMany
    public List<WorkflowNodeEntity> nodes;

}
