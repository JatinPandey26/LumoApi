package com.lumo.core.dto.trigger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.lumo.core.ENUM.TriggerType;
import lombok.Data;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = GithubIssueCreatedTriggerPayload.class, name = "GITHUB_ISSUE_CREATED")
})
@Data
public abstract class TriggerPayload{
    TriggerType type;
}
