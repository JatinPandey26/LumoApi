package com.lumo.core.service.connector;

import com.lumo.core.dto.connector.ConnectorPostInstallationPayload;
import com.lumo.core.dto.connector.CreateConnectorRequest;

public interface ConnectorService {

    public long createConnector(CreateConnectorRequest createConnectorRequest);

    /**
     * Handles post-installation or post-connection setup for a connector.
     *
     * <p>
     * Some connectors (e.g., GitHub) send additional metadata upon installation,
     * such as an installation ID, OAuth tokens, or other connection identifiers.
     * This method provides a generic hook to persist or process that data.
     * Future connectors requiring similar post-installation handling
     * can implement this method as needed.
     * </p>
     *
     * @param connectorPostInstallationPayload payload containing connector-specific metadata
     */
    public void handlePostInstallation(ConnectorPostInstallationPayload connectorPostInstallationPayload);
}
