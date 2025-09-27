package com.lumo.core.dto.workflow.node;

import com.lumo.core.ENUM.NodeType;

public class ActionNode extends AbstractWorkflowNode {

    @Override
    public NodeType getNodeType() {
        return NodeType.ACTION;
    }
}
