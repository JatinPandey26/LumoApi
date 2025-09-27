package com.lumo.core.service.workflow;

import com.lumo.core.dto.trigger.Trigger;
import com.lumo.core.dto.workflow.Workflow;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
public class WorkflowExecutorImpl implements WorkflowExecutor{

    @Override
    public void execute(Workflow workflow) {

    }

    @Override
    public void execute(Workflow workflow, Trigger trigger){
        // get start node from trigger
        // generate actionTree from all action nodes fetched
        // start execution
    }

    @Override
    public void execute(Workflow workflow, Map<String, Object> context) {

    }

    @Override
    public void executeById(long workflowId) {

    }

    @Override
    public void schedule(Workflow workflow, Instant scheduledTime) {

    }

    @Override
    public void retry(Workflow workflow, int maxRetries) {

    }
}
