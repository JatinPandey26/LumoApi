package com.lumo.core.dto.workflow.node;

import java.util.List;

public class NodeResult {
    private final boolean success;
    private final Object output;
    private final List<String> nextNodeIds;

    public NodeResult(boolean success, Object output, List<String> nextNodeIds) {
        this.success = success;
        this.output = output;
        this.nextNodeIds = nextNodeIds;
    }

    public boolean isSuccess() { return success; }
    public Object getOutput() { return output; }
    public List<String> getNextNodeIds() { return nextNodeIds; }
}

