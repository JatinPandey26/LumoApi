package com.lumo.core.mapper;

import com.lumo.core.Entities.ConnectorEntity;
import com.lumo.core.ENUM.ConnectorStatus;
import com.lumo.core.ENUM.ConnectorType;
import com.lumo.core.dto.connector.Connector;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ConnectorMapperTest {

    private final ConnectorMapper mapper = Mappers.getMapper(ConnectorMapper.class);

    @Test
    void shouldMapEntityToDto() {
        // given
        ConnectorEntity entity = new ConnectorEntity();
        entity.setId(1L);
        entity.setName("GitHub");
        entity.setType(ConnectorType.GITHUB);
        entity.setStatus(ConnectorStatus.ACTIVE);
        entity.setMetaData(new HashMap<>(Map.of("url", "https://github.com")));

        // when
        Connector dto = mapper.toDto(entity);

        // then
        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getName()).isEqualTo("GitHub");
        assertThat(dto.getType()).isEqualTo(ConnectorType.GITHUB);
        assertThat(dto.getStatus()).isEqualTo(ConnectorStatus.ACTIVE);
        assertThat(dto.getMetaData()).containsEntry("url", "https://github.com");
    }

    @Test
    void shouldMapDtoToEntity() {
        // given
        Connector dto = Connector.builder()
                .id(2L)
                .name("Slack")
                .type(ConnectorType.GITHUB)
                .status(ConnectorStatus.INITIAL)
                .metaData(Map.of("token", "abc123"))
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();

        // when
        ConnectorEntity entity = mapper.toEntity(dto);

        // then
        assertThat(entity.getId()).isEqualTo(2L);
        assertThat(entity.getName()).isEqualTo("Slack");
        assertThat(entity.getType()).isEqualTo(ConnectorType.GITHUB);
        assertThat(entity.getStatus()).isEqualTo(ConnectorStatus.INITIAL);
        assertThat(entity.getMetaData()).containsEntry("token", "abc123");
    }
}
