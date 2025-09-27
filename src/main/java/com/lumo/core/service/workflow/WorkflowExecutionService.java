package com.lumo.core.service.workflow;

import com.lumo.core.ENUM.TriggerType;
import com.lumo.core.dto.trigger.TriggerEvent;

public interface WorkflowExecutionService {
    void handleTrigger(TriggerType triggerType, TriggerEvent event);

    void executeWorkflow(Long workflowId, Object payload);

    boolean canExecute(Long workflowId);

    void retryExecution(Long executionId);

    void cancelExecution(Long executionId);
}
