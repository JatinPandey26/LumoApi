package com.lumo.core.service.workflow;

import com.lumo.core.Entities.WorkflowEntity;
import com.lumo.core.repository.WorkflowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkflowServiceImpl implements WorkflowService {

    private final WorkflowRepository workflowRepository;
    @Override
    public String create(String name) {

        WorkflowEntity workflow = new WorkflowEntity();
        workflow.setName(name);
        WorkflowEntity savedWorkflow =  workflowRepository.save(workflow);
        return savedWorkflow.getName();

    }
}
