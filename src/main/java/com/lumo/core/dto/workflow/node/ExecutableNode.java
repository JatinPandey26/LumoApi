package com.lumo.core.dto.workflow.node;

public interface ExecutableNode extends BaseWorkflowNode {
    NodeResult execute(NodeContext context);
}
