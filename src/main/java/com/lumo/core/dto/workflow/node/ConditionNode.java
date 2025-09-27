package com.lumo.core.dto.workflow.node;

import com.lumo.core.ENUM.NodeType;

import java.util.List;
import java.util.Map;

public class ConditionNode implements ExecutableNode {
    private final Long id;
    private final String name;
    private final String workflowId;
    private final String expression;
    private final String nextTrueNode;
    private final String nextFalseNode;

    public ConditionNode(Long id, String name, String workflowId,
                         String expression, String nextTrueNode,String nextFalseNode) {
        this.id = id;
        this.name = name;
        this.workflowId = workflowId;
        this.expression = expression;
        this.nextTrueNode=nextTrueNode;
        this.nextFalseNode=nextFalseNode;
    }

    @Override
    public NodeType getNodeType() { return NodeType.IF_CONDITION; }

    @Override
    public long getId() { return id; }


    @Override
    public NodeResult execute(NodeContext context) {
        boolean result = evaluateExpression(context);
        // Decide next node based on result
        String nextNodeId = null;

        if(result) nextNodeId = nextTrueNode;
        else nextNodeId=nextFalseNode;

        return new NodeResult(true, result, nextNodeId == null ? List.of() : List.of(nextNodeId));
    }

    private boolean evaluateExpression(NodeContext context) {
        Map<String,Object> vars = context.getAll();
        try {
//            return org.mvel2.MVEL.evalToBoolean(expression, vars);
            //TODO : work on this feature
            return true;
        } catch (Exception ex) {

            throw new RuntimeException("Condition evaluation failed: " + ex.getMessage(), ex);
        }
    }
}
