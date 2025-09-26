package com.lumo.core.dto.trigger;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data //TODO: Study this
public class GithubIssueCreatedTriggerPayload extends TriggerPayload {
    String repoName;
}
