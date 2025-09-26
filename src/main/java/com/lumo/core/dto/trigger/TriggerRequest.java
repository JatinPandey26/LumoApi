package com.lumo.core.dto.trigger;

import com.lumo.core.ENUM.TriggerType;
import lombok.Data;

@Data
public class TriggerRequest {

    String name;
    Long connectorId;
    Long workflowId;
    TriggerType type;
    TriggerPayload triggerPayload;

}
