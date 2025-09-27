package com.lumo.core.resolver;


import com.lumo.core.ENUM.TriggerType;
import com.lumo.core.dto.connector.GithubWebhookEvent;
import com.lumo.core.ENUM.GithubAction;
import com.lumo.core.ENUM.GithubEvent;
import org.springframework.stereotype.Component;
/*
TODO : we may need to introduce a TriggerResolver interface when we move to another connector
*/

@Component
public class GithubWebhookTriggerResolver {

    public TriggerType resolve(String eventName, GithubWebhookEvent eventPayload) {
        GithubEvent event = GithubEvent.fromString(eventName);

        return switch (event) {
            case ISSUES -> resolveIssue(eventPayload);
            case PULL_REQUEST -> TriggerType.UNKNOWN; // add later
            default -> TriggerType.UNKNOWN;
        };
    }

    private TriggerType resolveIssue(GithubWebhookEvent payload) {
        String actionStr = payload.getAction();
        GithubAction action = GithubAction.fromString(actionStr);

        return switch (action) {
            case OPENED -> TriggerType.GITHUB_ISSUE_CREATED;
            case EDITED -> TriggerType.GITHUB_ISSUE_UPDATED;
            case CLOSED -> TriggerType.GITHUB_ISSUE_CLOSED;
            default -> TriggerType.UNKNOWN;
        };
    }

}
