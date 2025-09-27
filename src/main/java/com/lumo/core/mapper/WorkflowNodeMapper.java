package com.lumo.core.mapper;

import com.lumo.core.Entities.ConnectorEntity;
import com.lumo.core.Entities.WorkflowEntity;
import com.lumo.core.Entities.WorkflowNodeEntity;
import com.lumo.core.dto.trigger.Trigger;
import com.lumo.core.dto.workflow.node.WorkflowNode;
import com.lumo.core.dto.workflow.node.WorkflowNodeRequest;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

import static com.lumo.core.mapper.TriggerMapper.CONNECTOR_MAPPER_INSTANCE;
import static com.lumo.core.mapper.TriggerMapper.WORKFLOW_MAPPER_INSTANCE;

@Mapper(componentModel = "spring")
public interface WorkflowNodeMapper {

    WorkflowNode toDtoHelper(WorkflowNodeEntity workflowEntity);

    @Mapping(target = "workflow",source = "workflowId",qualifiedByName = "mapWorkflow")
    @Mapping(target = "connector",source = "connectorId",qualifiedByName = "mapConnector")
    WorkflowNodeEntity toEntityFromRequest(WorkflowNodeRequest workflowNodeRequest);

    @Named("toDto")
    default WorkflowNode toDto(WorkflowNodeEntity workflowNodeEntity){
        WorkflowNode workflowNode = toDtoHelper(workflowNodeEntity);
        workflowNode.setId(workflowNodeEntity.getId());
        workflowNode.setName(workflowNodeEntity.getName());
        workflowNode.setConnector(CONNECTOR_MAPPER_INSTANCE.toDto(workflowNodeEntity.getConnector()));
        workflowNode.setWorkflow(WORKFLOW_MAPPER_INSTANCE.toDto(workflowNodeEntity.getWorkflow()));
        workflowNode.setCreatedAt(workflowNodeEntity.getCreatedAt());
        workflowNode.setUpdatedAt(workflowNodeEntity.getUpdatedAt());
        workflowNode.setType(workflowNodeEntity.getType());
        workflowNode.setNextNodes(workflowNodeEntity.getNextNodes());
        return workflowNode;
    }


    @IterableMapping(qualifiedByName = "toDto")
    List<WorkflowNode> toDtos(List<WorkflowNodeEntity> workflowNodeEntities);

    @Named("mapWorkflow")
    default WorkflowEntity mapWorkflow(Long workflowId){
        if (workflowId == null) {
            return null;
        }

        WorkflowEntity workflow = new WorkflowEntity();
        workflow.setId(workflowId);
        return workflow;
    }

    @Named("mapConnector")
    default ConnectorEntity mapConnector(Long connectorId){
        if (connectorId == null) {
            return null;
        }

        ConnectorEntity connector = new ConnectorEntity();
        connector.setId(connectorId);
        return connector;
    }
}
