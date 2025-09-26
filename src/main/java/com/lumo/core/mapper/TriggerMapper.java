package com.lumo.core.mapper;

import com.lumo.core.Entities.Connector;
import com.lumo.core.Entities.TriggerEntity;
import com.lumo.core.Entities.Workflow;
import com.lumo.core.dto.trigger.Trigger;
import com.lumo.core.dto.trigger.TriggerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TriggerMapper {

    TriggerMapper INSTANCE = Mappers.getMapper(TriggerMapper.class);

    @Mapping(target = "connector", source = "connectorId", qualifiedByName = "mapConnector")
    @Mapping(target = "workflow",source = "workflowId",qualifiedByName = "mapWorkflow")
    TriggerEntity toEntity(TriggerRequest trigger);

    Trigger toDto(TriggerEntity entity);

    @Named("mapConnector")
    default Connector mapConnector(Long connectorId) {
        if (connectorId == null) {
            return null;
        }
        Connector connector = new Connector();
        connector.setId(connectorId); // only set id, Hibernate will treat it as reference
        return connector;
    }

    @Named("mapWorkflow")
    default Workflow mapWorkflow(Long workflowId){
        if (workflowId == null) {
            return null;
        }

        Workflow workflow = new Workflow();
        workflow.setId(workflowId);
        return workflow;
    }
}
