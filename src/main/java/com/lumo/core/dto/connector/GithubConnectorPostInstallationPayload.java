package com.lumo.core.dto.connector;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GithubConnectorPostInstallationPayload implements ConnectorPostInstallationPayload{
    long installationId;
    long connectorId;
}
