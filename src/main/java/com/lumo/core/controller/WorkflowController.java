package com.lumo.core.controller;

import com.lumo.core.dto.api.ApiResponse;
import com.lumo.core.dto.trigger.Trigger;
import com.lumo.core.dto.trigger.TriggerRequest;
import com.lumo.core.service.trigger.TriggerService;
import com.lumo.core.service.workflow.WorkflowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/workflow")
@RequiredArgsConstructor
public class WorkflowController {

    private final WorkflowService workflowService;
    private final TriggerService triggerService;

    @PostMapping(value = "/create/{name}")
    public ResponseEntity<ApiResponse<String>> createWorkflow(@PathVariable String name) {
        String workflowName = workflowService.create(name);
        return ApiResponse.success(workflowName, "Workflow created successfully");
    }

    @PostMapping(value = "/trigger/add")
    public ResponseEntity<ApiResponse<Long>> addTrigger(@RequestBody TriggerRequest triggerRequest) {

        Long triggerId = triggerService.createTrigger(triggerRequest);
        return ApiResponse.success(triggerId, "Trigger created successfully");

    }

}
