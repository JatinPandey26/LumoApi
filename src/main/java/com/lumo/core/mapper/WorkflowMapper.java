package com.lumo.core.mapper;

import com.lumo.core.Entities.WorkflowEntity;
import com.lumo.core.dto.workflow.Workflow;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {TriggerMapper.class})
public interface WorkflowMapper {

    Workflow toDto(WorkflowEntity workflowEntity);

    WorkflowEntity toEntity(Workflow workflow);

}
