package com.lumo.core.dto.connector;

import com.lumo.core.ENUM.ConnectorType;
import lombok.Data;

@Data
public class ConnectorPayload {

    private String connectorName;
    private ConnectorType connectorType;

}
