package com.lumo.core.service.workflow;

import com.lumo.core.ENUM.WorkflowStatus;
import com.lumo.core.dto.trigger.Trigger;
import com.lumo.core.dto.workflow.Workflow;
import java.time.Instant;
import java.util.Map;

public interface WorkflowExecutor {

    void execute(Workflow workflow);

    void execute(Workflow workflow, Trigger trigger);

    void execute(Workflow workflow, Map<String, Object> context);

    void executeById(long workflowId);

    void schedule(Workflow workflow, Instant scheduledTime);

    void retry(Workflow workflow, int maxRetries);

}
