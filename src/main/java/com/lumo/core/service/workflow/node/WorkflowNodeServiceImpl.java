package com.lumo.core.service.workflow.node;

import com.lumo.core.Entities.WorkflowNodeEntity;
import com.lumo.core.dto.workflow.node.WorkflowNodeRequest;
import com.lumo.core.dto.workflow.node.WorkflowNode;
import com.lumo.core.mapper.WorkflowNodeMapper;
import com.lumo.core.repository.WorkflowNodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkflowNodeServiceImpl implements WorkflowNodeService{

    private final WorkflowNodeRepository workflowNodeRepository;
    private final WorkflowNodeMapper workflowNodeMapper;

    @Override
    public WorkflowNode createNode(WorkflowNodeRequest request) {
        WorkflowNodeEntity workflowNodeEntity = workflowNodeMapper.toEntityFromRequest(request);
        WorkflowNodeEntity saved = this.workflowNodeRepository.save(workflowNodeEntity);
        return workflowNodeMapper.toDto(saved);
    }

    @Override
    public WorkflowNode updateNode(String nodeId, WorkflowNodeRequest request) {
        return null;
    }

    @Override
    public void deleteNode(String nodeId) {

    }

    @Override
    public WorkflowNode getNode(String nodeId) {
        return null;
    }

    @Override
    public List<WorkflowNode> getNodesByWorkflow(String workflowId) {
        return List.of();
    }

    @Override
    public WorkflowNode buildWorkflowTree(String workflowId, String startNodeId) {
        return null;
    }

    @Override
    public WorkflowNode updateNextNodes(long nodeId, List<String> nextNodes) {
        WorkflowNodeEntity node = workflowNodeRepository.findById(nodeId)
                .orElseThrow(() -> new RuntimeException("Node not found"));

        node.setNextNodes(nextNodes);
        WorkflowNodeEntity saved = workflowNodeRepository.save(node);
        return workflowNodeMapper.toDto(saved);
    }
}
