package com.lumo.core.controller;

import com.lumo.core.dto.api.ApiResponse;
import com.lumo.core.dto.connector.ConnectorPayload;
import com.lumo.core.dto.connector.ConnectorResgistrationResponse;
import com.lumo.core.dto.connector.GithubConnectorPostInstallationPayload;
import com.lumo.core.service.connector.ConnectorRegistrationService;
import com.lumo.core.service.connector.ConnectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/connector/register")
@RequiredArgsConstructor
public class ConnectorRegistrationController {

    private final ConnectorRegistrationService connectorRegistrationService;
    private final ConnectorService connectorService;

    @PostMapping("/github")
    public ResponseEntity<ApiResponse<ConnectorResgistrationResponse>> githubConnectorAuth(
            @RequestBody ConnectorPayload connectorPayload) {

        ConnectorResgistrationResponse response =
                connectorRegistrationService.registerConnector(connectorPayload);

        return ApiResponse.success(response, "GitHub connector registered successfully");
    }

    @GetMapping("/github/post-install")
    public ResponseEntity<ApiResponse<Void>> githubCallbackController(
            @RequestParam("installation_id") Long installationId,
            @RequestParam(value = "setup_action", required = false) String setupAction,
            @RequestParam(value = "state") String state) {

        connectorService.handlePostInstallation(
                new GithubConnectorPostInstallationPayload(installationId, Long.parseLong(state))
        );

        return ApiResponse.success("GitHub connector post-installation handled successfully");
    }
}
