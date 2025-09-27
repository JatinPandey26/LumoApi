package com.lumo.core.mapper;

import com.lumo.core.Entities.WorkflowEntity;
import com.lumo.core.ENUM.WorkflowStatus;
import com.lumo.core.dto.workflow.Workflow;
import com.lumo.core.mapper.WorkflowMapper;
import org.hibernate.annotations.CurrentTimestamp;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WorkflowMapperTest {

    private final WorkflowMapper mapper = Mappers.getMapper(WorkflowMapper.class);

    @Test
    void shouldMapEntityToDto() {
        // given
        Instant instant = Instant.now();
        WorkflowEntity entity = new WorkflowEntity();
        entity.setId(1L);
        entity.setName("Test Workflow");
        entity.setStatus(WorkflowStatus.ACTIVE);
        entity.setUpdatedAt(instant);
        entity.setCreatedAt(instant);

        // when
        Workflow dto = mapper.toDto(entity);

        // then
        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getName()).isEqualTo("Test Workflow");
        assertThat(dto.getStatus()).isEqualTo(WorkflowStatus.ACTIVE);
        assertThat(dto.getCreatedAt()).isEqualTo(instant);
        assertThat(dto.getUpdatedAt()).isEqualTo(instant);

        // fields that don’t exist in entity will be null/empty in DTO
        assertThat(dto.getMetaData()).isEmpty();
    }

    @Test
    void shouldMapDtoToEntity() {
        // given
        Workflow dto = Workflow.builder()
                .id(2L)
                .name("Another Workflow")
                .status(WorkflowStatus.INITIAL)
                .triggerId(123L) // won’t map (no trigger field in entity)
                .metaData(Map.of("env", "dev")) // won’t map (entity doesn’t have metaData)
                .createdAt(Instant.now()) // won’t map (entity doesn’t have createdAt)
                .updatedAt(Instant.now()) // won’t map (entity doesn’t have updatedAt)
                .build();

        // when
        WorkflowEntity entity = mapper.toEntity(dto);

        // then
        assertThat(entity.getId()).isEqualTo(2L);
        assertThat(entity.getName()).isEqualTo("Another Workflow");
        assertThat(entity.getStatus()).isEqualTo(WorkflowStatus.INITIAL);

        // fields missing in entity are simply ignored
        assertThat(entity.getNodes()).isNull();
    }
}
