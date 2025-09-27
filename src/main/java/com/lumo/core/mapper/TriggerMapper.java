package com.lumo.core.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumo.core.ENUM.TriggerType;
import com.lumo.core.Entities.WorkflowNodeEntity;
import com.lumo.core.dto.trigger.Trigger;
import com.lumo.core.dto.trigger.TriggerPayload;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring" , uses = {ConnectorMapper.class, WorkflowMapper.class})
public interface TriggerMapper {

    TriggerMapper INSTANCE = Mappers.getMapper(TriggerMapper.class);
    ConnectorMapper CONNECTOR_MAPPER_INSTANCE = Mappers.getMapper(ConnectorMapper.class);
    WorkflowMapper WORKFLOW_MAPPER_INSTANCE = Mappers.getMapper(WorkflowMapper.class);

    @Mapping(target = "triggerType", source = "workflowNodeEntity", qualifiedByName = "extractTriggerType")
    @Mapping(target = "triggerPayload", source = "config", qualifiedByName = "mapConfigToTriggerPayload")
    Trigger maptoTriggerHelper(WorkflowNodeEntity workflowNodeEntity);

    @Named("toTrigger")
    default Trigger toTrigger(WorkflowNodeEntity workflowNodeEntity){
        Trigger trigger = maptoTriggerHelper(workflowNodeEntity);
        trigger.setId(workflowNodeEntity.getId());
        trigger.setName(workflowNodeEntity.getName());
        trigger.setConnector(CONNECTOR_MAPPER_INSTANCE.toDto(workflowNodeEntity.getConnector()));
        trigger.setWorkflow(WORKFLOW_MAPPER_INSTANCE.toDto(workflowNodeEntity.getWorkflow()));
        trigger.setCreatedAt(workflowNodeEntity.getCreatedAt());
        trigger.setUpdatedAt(workflowNodeEntity.getUpdatedAt());
        trigger.setType(workflowNodeEntity.getType());
        trigger.setNextNodes(workflowNodeEntity.getNextNodes());
        return trigger;
    }

    @IterableMapping(qualifiedByName = "toTrigger")
    List<Trigger> toTriggers(List<WorkflowNodeEntity> workflowNodeEntities);

    @Named("extractTriggerType")
    default TriggerType extractTriggerType(WorkflowNodeEntity entity) {
        if (entity == null || entity.getConfig() == null) {
            return null;
        }
        Object typeObj = entity.getConfig().get("triggerType");
        if (typeObj == null) {
            return null;
        }
        try {
            return TriggerType.valueOf(typeObj.toString());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    @Named("mapConfigToTriggerPayload")
    default TriggerPayload mapConfigToTriggerPayload(Map<String, Object> config) {
        if (config == null || config.isEmpty()) return null;

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper.convertValue(config, TriggerPayload.class);
    }
}
