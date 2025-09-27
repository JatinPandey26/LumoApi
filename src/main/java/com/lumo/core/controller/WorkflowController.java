package com.lumo.core.controller;

import com.lumo.core.dto.api.ApiResponse;
import com.lumo.core.dto.trigger.TriggerRequest;
import com.lumo.core.dto.workflow.node.WorkflowNode;
import com.lumo.core.dto.workflow.node.WorkflowNodeRequest;
import com.lumo.core.service.workflow.WorkflowService;
import com.lumo.core.service.workflow.node.WorkflowNodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/workflow")
@RequiredArgsConstructor
public class WorkflowController {

    private final WorkflowService workflowService;
    private final WorkflowNodeService workflowNodeService;

    @PostMapping(value = "/create/{name}")
    public ResponseEntity<ApiResponse<String>> createWorkflow(@PathVariable String name) {
        String workflowName = workflowService.create(name);
        return ApiResponse.success(workflowName, "Workflow created successfully");
    }

    @PostMapping(value = "/trigger/add")
    public ResponseEntity<ApiResponse<WorkflowNode>> addTrigger(@RequestBody WorkflowNodeRequest workflowNodeRequest) {
        WorkflowNode node = workflowNodeService.createNode(workflowNodeRequest);
        return ApiResponse.success(node, "Trigger created successfully");
    }

    @PostMapping("/node/add")
    public ResponseEntity<ApiResponse<WorkflowNode>> addNode(@RequestBody WorkflowNodeRequest workflowNodeRequest){
        WorkflowNode workflowNodeResponse = workflowNodeService.createNode(workflowNodeRequest);
        return ApiResponse.success(workflowNodeResponse,"Node created successfully");
    }


    @PostMapping("/workflow/node/{nodeId}/next-nodes")
    public ResponseEntity<ApiResponse<WorkflowNode>> updateNextNodes(
            @PathVariable long nodeId,
            @RequestBody List<String> nextNodes) {

        WorkflowNode workflowNode = this.workflowNodeService.updateNextNodes(nodeId,nextNodes);
        return ApiResponse.success(workflowNode,"workflow node updated with new next nodes");
    }


}
