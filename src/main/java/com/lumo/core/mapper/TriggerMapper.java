package com.lumo.core.mapper;

import com.lumo.core.Entities.ConnectorEntity;
import com.lumo.core.Entities.TriggerEntity;
import com.lumo.core.Entities.WorkflowEntity;
import com.lumo.core.dto.connector.Connector;
import com.lumo.core.dto.trigger.Trigger;
import com.lumo.core.dto.trigger.TriggerRequest;
import com.lumo.core.dto.workflow.Workflow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {ConnectorMapper.class, WorkflowMapper.class})
public interface TriggerMapper {

    TriggerMapper INSTANCE = Mappers.getMapper(TriggerMapper.class);

    @Mapping(target = "connector", source = "connectorId", qualifiedByName = "mapConnector")
    @Mapping(target = "workflow",source = "workflowId",qualifiedByName = "mapWorkflow")
    TriggerEntity toEntity(TriggerRequest trigger);

    Trigger toDto(TriggerEntity entity);

    List<TriggerEntity> toEntities(List<Trigger> triggers);

    List<Trigger> toDtos(List<TriggerEntity> triggerEntities);

    @Named("mapConnector")
    default ConnectorEntity mapConnector(Long connectorId) {
        if (connectorId == null) {
            return null;
        }
        ConnectorEntity connector = new ConnectorEntity();
        connector.setId(connectorId); // only set id, Hibernate will treat it as reference
        return connector;
    }

    @Named("mapWorkflow")
    default WorkflowEntity mapWorkflow(Long workflowId){
        if (workflowId == null) {
            return null;
        }

        WorkflowEntity workflow = new WorkflowEntity();
        workflow.setId(workflowId);
        return workflow;
    }
}
