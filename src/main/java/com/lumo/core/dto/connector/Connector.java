package com.lumo.core.dto.connector;

import com.lumo.core.ENUM.ConnectorStatus;
import com.lumo.core.ENUM.ConnectorType;
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
public class Connector {

    private long id;

    private String name;

    private ConnectorType type;

    private ConnectorStatus status = ConnectorStatus.INITIAL;

    private List<Long> triggerIds = Collections.emptyList();

    private Map<String, String> metaData = Collections.emptyMap();

    private Instant createdAt;

    private Instant updatedAt;
}

