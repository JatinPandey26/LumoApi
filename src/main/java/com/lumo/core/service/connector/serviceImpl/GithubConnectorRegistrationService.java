package com.lumo.core.service.connector.serviceImpl;

import com.lumo.core.dto.connector.*;
import com.lumo.core.service.connector.ConnectorRegistrationService;
import com.lumo.core.service.connector.ConnectorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service implementation for handling GitHub connector authentication.
 * This service is responsible for generating the GitHub OAuth URL
 * with the correct state parameter and saving connector details.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GithubConnectorRegistrationService implements ConnectorRegistrationService {

    @Value("${automata.connector.github.clientId}")
    private String clientID;

    @Value("${automata.connector.github.redirectURI}")
    private String redirectURI;

    @Value("${automata.connector.github.scope}")
    private String scope;

    @Value("${automata.connector.github.githubAuthURL}")
    private String githubAuthURL;

    private final ConnectorService connectorService;

    /**
     * Generates the GitHub authorization URL with a unique state parameter.
     * This state parameter ensures CSRF protection and links the connector record
     * created in the system with the GitHub OAuth callback response.
     *
     * @param connectorPayload - contains connector details (type, name, etc.)
     * @return ConnectorAuthResponse containing the generated GitHub OAuth URL
     */
    @Override
    public ConnectorResgistrationResponse registerConnector(ConnectorPayload connectorPayload) {
        // Generate a unique state (UUID) for CSRF protection
        String state = UUID.randomUUID().toString();
        log.debug("Generated OAuth state UUID: {}", state);

        // Create a connector request to persist in the system
        CreateConnectorRequest createConnectorRequest =
                new GithubCreateConnectorRequest(
                        connectorPayload.getConnectorType(),
                        connectorPayload.getConnectorName(),
                        state
                );

        // Save the connector and retrieve its database ID
        long connectorId = connectorService.createConnector(createConnectorRequest);
        log.info("Connector created with ID: {} and state: {}", connectorId, state);

        // Construct the GitHub authorization URL
        String githubUrl = githubAuthURL
                + "client_id=" + clientID
                + "&redirect_uri=" + redirectURI
                + "&scope=" + scope
                + "&state=" + connectorId;

        log.debug("Generated GitHub OAuth URL: {}", githubUrl);

        // TODO: Persist the state value along with connectorId in DB for validation during callback
        //       This helps in mapping the incoming GitHub callback to the right connector.

        return new GithubConnectorResgistrationResponse(githubUrl);
    }

}
