package com.lumo.core.mapper;

import com.lumo.core.Entities.ConnectorEntity;
import com.lumo.core.dto.connector.Connector;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {TriggerMapper.class})
public interface ConnectorMapper {

    Connector toDto(ConnectorEntity connectorEntity);

    ConnectorEntity toEntity(Connector connector);

}
