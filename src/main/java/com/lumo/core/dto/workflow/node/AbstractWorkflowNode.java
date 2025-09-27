package com.lumo.core.dto.workflow.node;

import com.lumo.core.ENUM.NodeType;
import com.lumo.core.dto.connector.Connector;
import com.lumo.core.dto.workflow.Workflow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.List;

@Data
public abstract class AbstractWorkflowNode implements BaseWorkflowNode{

    private long id;

    private String name;

    private NodeType type;

    private Workflow workflow;

    private Connector connector;

    private Instant createdAt;

    private Instant updatedAt;

    private List<String> nextNodes;
}

