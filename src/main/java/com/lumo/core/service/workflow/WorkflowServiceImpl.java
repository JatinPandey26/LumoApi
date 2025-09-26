package com.lumo.core.service.workflow;

import com.lumo.core.Entities.Workflow;
import com.lumo.core.repository.WorkflowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkflowServiceImpl implements WorkflowService {

    private final WorkflowRepository workflowRepository;
    @Override
    public String create(String name) {

        Workflow workflow = new Workflow();
        workflow.setName(name);
       Workflow savedWorkflow =  workflowRepository.save(workflow);
       return savedWorkflow.getName();

    }
}
