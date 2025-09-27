package com.lumo.core.mapper;

import com.lumo.core.ENUM.NodeType;
import com.lumo.core.ENUM.TriggerType;
import com.lumo.core.Entities.WorkflowNodeEntity;
import com.lumo.core.TestObjectFactory;
import com.lumo.core.dto.trigger.Trigger;
import com.lumo.core.dto.workflow.node.WorkflowNode;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.assertj.core.api.Assertions.assertThat;

public class WorkflowNodeMapperTest {

    private final TriggerMapper mapper = Mappers.getMapper(TriggerMapper.class);
    private final WorkflowNodeMapper workflowNodeMapper = Mappers.getMapper(WorkflowNodeMapper.class);
    @Test
    void shouldMapToTrigger(){

        WorkflowNodeEntity workflowNodeEntity = TestObjectFactory.getWorkflowNodeEntityForTrigger();

        Trigger trigger = mapper.toTrigger(workflowNodeEntity);


        assertThat(trigger).isNotNull();

        // Inherited fields from AbstractWorkflowNode
        assertThat(trigger.getId()).isEqualTo(workflowNodeEntity.getId());
        assertThat(trigger.getName()).isEqualTo(workflowNodeEntity.getName());
        assertThat(trigger.getCreatedAt()).isEqualTo(workflowNodeEntity.getCreatedAt());
        assertThat(trigger.getUpdatedAt()).isEqualTo(workflowNodeEntity.getUpdatedAt());

        // Workflow & Connector mapping
        if (workflowNodeEntity.getWorkflow() != null) {
            assertThat(trigger.getWorkflow()).isNotNull();
            assertThat(trigger.getWorkflow().getId()).isEqualTo(workflowNodeEntity.getWorkflow().getId());
        }

        if (workflowNodeEntity.getConnector() != null) {
            assertThat(trigger.getConnector()).isNotNull();
            assertThat(trigger.getConnector().getId()).isEqualTo(workflowNodeEntity.getConnector().getId());
        }

        // Trigger-specific fields
        assertThat(trigger.getTriggerType()).isEqualTo(TriggerType.GITHUB_ISSUE_CREATED);
        assertThat(trigger.getTriggerPayload()).isNotNull();
        assertThat(trigger.getNextNodes()).hasSameElementsAs(workflowNodeEntity.getNextNodes());
        // NodeType
        assertThat(trigger.getNodeType()).isEqualTo(NodeType.TRIGGER);

    }

    @Test
    void shouldMapWorkflowNode(){
        WorkflowNodeEntity workflowNodeEntity = TestObjectFactory.getWorkflowNodeEntity();
        WorkflowNode workflowNode = workflowNodeMapper.toDto(workflowNodeEntity);

        assertThat(workflowNode.getId()).isEqualTo(1L);
        assertThat(workflowNode.getName()).isEqualTo("Workflow Node");

        // Workflow & Connector mapping
        if (workflowNodeEntity.getWorkflow() != null) {
            assertThat(workflowNode.getWorkflow()).isNotNull();
            assertThat(workflowNode.getWorkflow().getId()).isEqualTo(workflowNodeEntity.getWorkflow().getId());
        }

        if (workflowNodeEntity.getConnector() != null) {
            assertThat(workflowNode.getConnector()).isNotNull();
            assertThat(workflowNode.getConnector().getId()).isEqualTo(workflowNodeEntity.getConnector().getId());
        }

        assertThat(workflowNode.getCreatedAt()).isNotNull();
        assertThat(workflowNode.getUpdatedAt()).isNotNull();

        // specific fields
        assertThat(workflowNode.getConfig()).isEqualTo(workflowNodeEntity.getConfig());
        assertThat(workflowNode.getNextNodes()).hasSameElementsAs(workflowNodeEntity.getNextNodes());

        // NodeType
        assertThat(workflowNode.getNodeType()).isEqualTo(NodeType.WORKFLOW);
        
    }   

}
