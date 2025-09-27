package com.lumo.core.dto.workflow.node;

import com.lumo.core.ENUM.NodeType;

public interface BaseWorkflowNode {
    long getId();
    NodeType getNodeType();
}
