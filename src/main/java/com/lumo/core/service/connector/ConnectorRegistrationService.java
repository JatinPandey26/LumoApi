package com.lumo.core.service.connector;

import com.lumo.core.dto.connector.ConnectorPayload;
import com.lumo.core.dto.connector.ConnectorResgistrationResponse;

public interface ConnectorRegistrationService {

    public ConnectorResgistrationResponse registerConnector(ConnectorPayload connectorPayload);

}
