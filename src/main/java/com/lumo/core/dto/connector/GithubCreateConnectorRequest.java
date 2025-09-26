package com.lumo.core.dto.connector;

import com.lumo.core.ENUM.ConnectorType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GithubCreateConnectorRequest implements  CreateConnectorRequest{

    ConnectorType connectorType;
    String connectorName;
    String state;

}
