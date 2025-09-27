package com.lumo.core.service.connector.serviceImpl;

import com.lumo.core.ENUM.ConnectorStatus;
import com.lumo.core.ENUM.MetaDataKeys;
import com.lumo.core.Entities.ConnectorEntity;
import com.lumo.core.dto.connector.ConnectorPostInstallationPayload;
import com.lumo.core.dto.connector.CreateConnectorRequest;
import com.lumo.core.dto.connector.GithubConnectorPostInstallationPayload;
import com.lumo.core.dto.connector.GithubCreateConnectorRequest;
import com.lumo.core.repository.ConnectorRepository;
import com.lumo.core.service.connector.ConnectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GithubConnectorServiceImpl implements ConnectorService {
    private final ConnectorRepository connectorRepository;

    @Override
    public long createConnector(CreateConnectorRequest createConnectorRequest) {

        ConnectorEntity connector = new ConnectorEntity();
        GithubCreateConnectorRequest githubCreateConnectorRequest = (GithubCreateConnectorRequest)createConnectorRequest;
        connector.setName(githubCreateConnectorRequest.getConnectorName());
        connector.setType(githubCreateConnectorRequest.getConnectorType());
        HashMap<String,String> metaData = new HashMap<>();
        metaData.put(MetaDataKeys.CONNECTOR_STATE.toString(), githubCreateConnectorRequest.getState());
        connector.setMetaData(metaData);



        return this.connectorRepository.save(connector).getId();
    }

    @Override
    public void handlePostInstallation(ConnectorPostInstallationPayload connectorPostInstallationPayload) {

        GithubConnectorPostInstallationPayload githubConnectorPostInstallationPayload = (GithubConnectorPostInstallationPayload) connectorPostInstallationPayload;
        Optional<ConnectorEntity> connectorOptional = connectorRepository.findById(Long.valueOf(githubConnectorPostInstallationPayload.getConnectorId()));
        if(!connectorOptional.isPresent()){
            throw new RuntimeException("Connector with this id not found " + githubConnectorPostInstallationPayload.getConnectorId());
        }
        ConnectorEntity connector = connectorOptional.get();
        connector.getMetaData().put(String.valueOf(MetaDataKeys.GITHUB_INSTALLATION_ID), String.valueOf(githubConnectorPostInstallationPayload.getInstallationId()));
        connector.setStatus(ConnectorStatus.ACTIVE);

        this.connectorRepository.save(connector);
    }
;}
