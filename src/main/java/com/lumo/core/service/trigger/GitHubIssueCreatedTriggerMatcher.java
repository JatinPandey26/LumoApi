package com.lumo.core.service.trigger;

import com.lumo.core.ENUM.TriggerType;
import com.lumo.core.dto.connector.GithubWebhookEvent;
import com.lumo.core.dto.trigger.TriggerEvent;
import com.lumo.core.dto.trigger.GithubIssueCreatedTriggerPayload;
import com.lumo.core.dto.trigger.Trigger;
import com.lumo.core.exception.InvalidTriggerEventException;
import com.lumo.core.exception.InvalidTriggerPayloadException;
import com.lumo.core.exception.TriggerTypeMismatchException;
import org.springframework.stereotype.Component;

@Component
public class GitHubIssueCreatedTriggerMatcher implements TriggerMatcher{
    @Override
    public TriggerType getType() {
        return TriggerType.GITHUB_ISSUE_CREATED;
    }

    @Override
    public boolean matches(Trigger trigger, TriggerEvent triggerEvent) {

        if (trigger.getTriggerType() != getType()) {
            throw new TriggerTypeMismatchException(
                    "Trigger type mismatch: expected " + getType() + " but got " + trigger.getTriggerType()
            );
        }

        if (!(trigger.getTriggerPayload() instanceof GithubIssueCreatedTriggerPayload)) {
            throw new InvalidTriggerPayloadException(
                    "Invalid trigger payload type: expected GithubIssueCreatedTriggerPayload but got "
                            + trigger.getTriggerPayload().getClass().getSimpleName()
            );
        }

        if (!(triggerEvent instanceof GithubWebhookEvent)) {
            throw new InvalidTriggerEventException(
                    "Invalid trigger event type: expected GithubWebhookEvent but got "
                            + triggerEvent.getClass().getSimpleName()
            );
        }

        GithubIssueCreatedTriggerPayload payload = (GithubIssueCreatedTriggerPayload) trigger.getTriggerPayload();
        GithubWebhookEvent githubWebhookEvent = (GithubWebhookEvent) triggerEvent;
        return payload.getRepoName().equals(githubWebhookEvent.getRepository().getName());
    }
}
