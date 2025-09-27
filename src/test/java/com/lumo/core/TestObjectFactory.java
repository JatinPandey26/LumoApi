package com.lumo.core;

import com.lumo.core.ENUM.ConnectorStatus;
import com.lumo.core.ENUM.ConnectorType;
import com.lumo.core.ENUM.NodeType;
import com.lumo.core.ENUM.WorkflowStatus;
import com.lumo.core.Entities.ConnectorEntity;
import com.lumo.core.Entities.WorkflowEntity;
import com.lumo.core.Entities.WorkflowNodeEntity;
import com.lumo.core.dto.connector.Connector;
import com.lumo.core.dto.workflow.Workflow;
import org.junit.platform.engine.support.hierarchical.Node;

import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestObjectFactory {

    public static ConnectorEntity getConnectorEntity() {
        ConnectorEntity entity = new ConnectorEntity();
        entity.setId(1L);
        entity.setName("Test Connector");
        entity.setType(ConnectorType.GITHUB);
        entity.setStatus(ConnectorStatus.INITIAL);

        HashMap<String, String> metaData = new HashMap<>();
        metaData.put("key1", "value1");
        entity.setMetaData(metaData);

        return entity;
    }

    public static Connector getConnectorDto() {
        return Connector.builder()
                .id(1L)
                .name("Test Connector")
                .type(ConnectorType.GITHUB)
                .status(ConnectorStatus.ACTIVE)
                .metaData(Collections.singletonMap("key1", "value1"))
                .triggerIds(Collections.singletonList(100L))
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
    }

    public static WorkflowEntity getWorkflowEntity() {
        WorkflowEntity entity = new WorkflowEntity();
        entity.setId(100L);
        entity.setName("Test Workflow");
        entity.setStatus(WorkflowStatus.INITIAL);
        entity.setNodes(Collections.<WorkflowNodeEntity>emptyList());

        // Simulate timestamps (since in-memory objects won’t get @CreationTimestamp)
        entity.setCreatedAt(Instant.now());
        entity.setUpdatedAt(Instant.now());

        return entity;
    }

    public static Workflow getWorkflowDto() {
        return Workflow.builder()
                .id(100L)
                .name("Test Workflow")
                .status(WorkflowStatus.INITIAL)
                .triggerId(200L)
                .metaData(Collections.singletonMap("k1", "v1"))
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
    }

    public static WorkflowNodeEntity getWorkflowNodeEntity(){
        WorkflowNodeEntity workflowNodeEntity = new WorkflowNodeEntity();
        workflowNodeEntity.setId(1);
        workflowNodeEntity.setName("Workflow Node");
        workflowNodeEntity.setConnector(getConnectorEntity());
        workflowNodeEntity.setWorkflow(getWorkflowEntity());

        Instant instant = Instant.now();
        workflowNodeEntity.setCreatedAt(instant);
        workflowNodeEntity.setUpdatedAt(instant);

        Map<String,Object> config = new HashMap<>();
        config.put("key","value");

        workflowNodeEntity.setConfig(config);
        workflowNodeEntity.setNextNodes(List.of("11","23","45"));
        workflowNodeEntity.setType(NodeType.WORKFLOW);

        return workflowNodeEntity;
    }

    public static WorkflowNodeEntity getWorkflowNodeEntityForTrigger(){
        WorkflowNodeEntity workflowNodeEntity = getWorkflowNodeEntity();
        workflowNodeEntity.setType(NodeType.TRIGGER);

        Map<String,Object> config = new HashMap<>();
        config.put("repoName","feb");
        config.put("triggerType","GITHUB_ISSUE_CREATED");
        config.put("firstNodeId","11");
        workflowNodeEntity.setConfig(config);

        // trigger has only 1 nextNode
        workflowNodeEntity.setNextNodes(List.of("11"));
        return workflowNodeEntity;
    }

}
