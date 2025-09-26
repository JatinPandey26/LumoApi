package com.lumo.core.dto.connector;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GithubConnectorResgistrationResponse implements ConnectorResgistrationResponse{
    private final String githubConnectorAuthURL;
}
