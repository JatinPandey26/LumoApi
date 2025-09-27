package com.lumo.core.dto.trigger;

import com.lumo.core.ENUM.NodeType;
import com.lumo.core.ENUM.TriggerType;
import com.lumo.core.dto.workflow.node.AbstractWorkflowNode;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Trigger extends AbstractWorkflowNode {
    private TriggerType triggerType;
    private TriggerPayload triggerPayload;

    @Override
    public NodeType getNodeType() {
        return NodeType.TRIGGER;
    }
}
