package com.lumo.core.dto.trigger;

import com.lumo.core.ENUM.TriggerType;
import lombok.Data;

import java.util.Map;

@Data
public class Trigger {
    private Long id;
    private String name;
    private String connectorID;
    private TriggerType type;
    private TriggerPayload triggerPayload;
}
