package com.lumo.core.dto.workflow.node;

import com.lumo.core.ENUM.NodeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowNode extends AbstractWorkflowNode{
    private Map<String, Object> config;


    @Override
    public NodeType getNodeType() {
        return NodeType.WORKFLOW;
    }
}
