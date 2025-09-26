package com.lumo.core.Entities;

import com.lumo.core.ENUM.TriggerType;
import com.lumo.core.dto.trigger.TriggerPayload;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "triggers")
@Data
public class TriggerEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Workflow workflow;

    @ManyToOne
    private Connector connector;

    @Enumerated(EnumType.STRING)
    private TriggerType type;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    private TriggerPayload triggerPayload;
}
