package com.lumo.core.dto.workflow.node;

import com.lumo.core.ENUM.NodeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowNodeRequest {

    private NodeType type;

    private String name;

    private Map<String, Object> config;

    private List<String> nextNodes;

    private long workflowId;

    private long connectorId;
}

