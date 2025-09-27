package com.lumo.core.mapper;

import com.lumo.core.Entities.WorkflowEntity;
import com.lumo.core.dto.workflow.Workflow;
import org.mapstruct.Mapper;

import java.util.Collections;

@Mapper(componentModel = "spring",uses = {TriggerMapper.class})
public interface WorkflowMapper {

    Workflow toDtoHelper(WorkflowEntity workflowEntity);

    WorkflowEntity toEntity(Workflow workflow);

    default Workflow toDto(WorkflowEntity workflowEntity){
        Workflow workflow = toDtoHelper(workflowEntity);
        workflow.setMetaData(Collections.emptyMap());
        workflow.setCreatedAt(workflowEntity.getCreatedAt());
        workflow.setUpdatedAt(workflowEntity.getUpdatedAt());
        return workflow;
    }


}
