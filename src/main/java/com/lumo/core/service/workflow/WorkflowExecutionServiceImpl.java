package com.lumo.core.service.workflow;

import com.lumo.core.ENUM.NodeType;
import com.lumo.core.ENUM.TriggerType;
import com.lumo.core.Entities.WorkflowNodeEntity;
import com.lumo.core.dto.trigger.TriggerEvent;
import com.lumo.core.dto.trigger.Trigger;
import com.lumo.core.mapper.TriggerMapper;
import com.lumo.core.mapper.WorkflowNodeMapper;
import com.lumo.core.repository.WorkflowNodeRepository;
import com.lumo.core.service.trigger.TriggerMatcher;
import com.lumo.core.service.trigger.TriggerMatcherRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkflowExecutionServiceImpl implements WorkflowExecutionService{

    private final TriggerMatcherRegistry triggerMatcherRegistry;
    private final TriggerMapper triggerMapper;
    private final WorkflowExecutor workflowExecutor;
    private final WorkflowNodeRepository workflowNodeRepository;
    private final WorkflowNodeMapper workflowNodeMapper;

    @Override
    public void handleTrigger(TriggerType triggerType, TriggerEvent event) {
        // 1. Fetch all triggers of the given type from DB
        List<WorkflowNodeEntity> triggerEntities = workflowNodeRepository.findByType(NodeType.TRIGGER);

        if (triggerEntities.isEmpty()) {
            // Optional: log
            System.out.println("No triggers found for type: " + triggerType);
            return;
        }

        // 2. Map to DTOs
        List<Trigger> triggers = triggerMapper.toTriggers(triggerEntities);

        // 3. Get the appropriate matcher for this trigger type
        TriggerMatcher triggerMatcher = triggerMatcherRegistry.getMatcher(triggerType);

        // 4. Track faulty workflows
        List<String> faultyWorkflows = new ArrayList<>();

        // 5. Filter triggers and execute workflows
        triggers.forEach(trigger -> {
            boolean matches;
            try {
                matches = triggerMatcher.matches(trigger, event);
            } catch (Exception ex) {
                String msg = String.format("Trigger %d (%s) failed during matching: %s",
                        trigger.getId(), trigger.getName(), ex.getMessage());
                faultyWorkflows.add(msg);
                ex.printStackTrace(); // or use proper logger
                return; // skip this trigger
            }

            if (!matches) return; // trigger not matching event

            try {
                if (trigger.getWorkflow() == null) {
                    faultyWorkflows.add(String.format("Trigger %d (%s) has no workflow assigned",
                            trigger.getId(), trigger.getName()));
                    return;
                }

                workflowExecutor.execute(trigger.getWorkflow());
            } catch (Exception ex) {
                String msg = String.format("Workflow %d (%s) execution failed: %s",
                        trigger.getWorkflow().getId(), trigger.getWorkflow().getName(), ex.getMessage());
                faultyWorkflows.add(msg);
                ex.printStackTrace(); // or use logger
            }
        });

        // 6. Optionally report all faulty workflows
        if (!faultyWorkflows.isEmpty()) {
            System.out.println("Faulty workflows report:");
            faultyWorkflows.forEach(System.out::println);
        }
    }


    @Override
    public void executeWorkflow(Long workflowId, Object payload) {

    }

    @Override
    public boolean canExecute(Long workflowId) {
        return false;
    }

    @Override
    public void retryExecution(Long executionId) {

    }

    @Override
    public void cancelExecution(Long executionId) {

    }
}
