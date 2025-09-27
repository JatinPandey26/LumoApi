package com.lumo.core.dto.trigger;

import com.lumo.core.ENUM.TriggerType;
import com.lumo.core.dto.connector.Connector;
import com.lumo.core.dto.workflow.Workflow;
import lombok.Data;

import java.time.Instant;
import java.util.Map;

@Data
public class Trigger {
    private Long id;
    private String name;
    private Connector connector;
    private Workflow workflow;
    private TriggerType type;
    private TriggerPayload triggerPayload;
    private Instant createdAt;
    private Instant updatedAt;
}
