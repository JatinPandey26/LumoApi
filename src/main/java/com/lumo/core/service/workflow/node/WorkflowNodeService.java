package com.lumo.core.service.workflow.node;

import com.lumo.core.dto.workflow.node.WorkflowNode;
import com.lumo.core.dto.workflow.node.WorkflowNodeRequest;


import java.util.List;

public interface WorkflowNodeService {

    /**
     * Create a new node in a workflow.
     * @param request Node creation request DTO
     * @return saved node DTO
     */
    WorkflowNode createNode(WorkflowNodeRequest request);

    /**
     * Update an existing node.
     * @param nodeId Node ID
     * @param request Node update request DTO
     * @return updated node DTO
     */
    WorkflowNode updateNode(String nodeId, WorkflowNodeRequest request);

    /**
     * Delete a node by its ID.
     * @param nodeId Node ID
     */
    void deleteNode(String nodeId);

    /**
     * Get a single node by its ID.
     * @param nodeId Node ID
     * @return Node DTO
     */
    WorkflowNode getNode(String nodeId);

    /**
     * Get all nodes of a workflow.
     * @param workflowId Workflow ID
     * @return List of node DTOs
     */
    List<WorkflowNode> getNodesByWorkflow(String workflowId);

    /**
     * Build a full workflow tree starting from a specific node.
     * @param workflowId Workflow ID
     * @param startNodeId Node ID to start execution from (e.g., trigger's firstNodeId)
     * @return root node with children recursively populated
     */
    WorkflowNode buildWorkflowTree(String workflowId, String startNodeId);

    WorkflowNode updateNextNodes(long nodeId , List<String> nextNodes);
}
