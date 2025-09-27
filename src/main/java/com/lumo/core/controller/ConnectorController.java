package com.lumo.core.controller;

import com.lumo.core.ENUM.TriggerType;
import com.lumo.core.dto.connector.GithubWebhookEvent;
import com.lumo.core.resolver.GithubWebhookTriggerResolver;
import com.lumo.core.service.workflow.WorkflowExecutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/connector")
@RequiredArgsConstructor
public class ConnectorController {

    private final GithubWebhookTriggerResolver githubWebhookTriggerResolver;
    private final WorkflowExecutionService workflowExecutionService;
    @PostMapping("/github/webhook")
    public void githubWebhook(  @RequestHeader("X-GitHub-Event") String eventType , @RequestBody GithubWebhookEvent event){

        TriggerType triggerType = githubWebhookTriggerResolver.resolve(eventType,event);
        workflowExecutionService.handleTrigger(triggerType,event);
    }


}
