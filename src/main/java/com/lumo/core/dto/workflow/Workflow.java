package com.lumo.core.dto.workflow;

import com.lumo.core.ENUM.WorkflowStatus;
import com.lumo.core.dto.trigger.Trigger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Workflow {

    private long id;

    private String name;

    private WorkflowStatus status = WorkflowStatus.INITIAL;

    // List of triggers; can be empty to avoid null pointer issues
    private List<Long> triggerIds = Collections.emptyList();

    // Optional metadata map
    private Map<String, String> metaData = Collections.emptyMap();

    private Instant createdAt;

    private Instant updatedAt;
}
