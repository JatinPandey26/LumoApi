package com.lumo.core.dto.connector;

import com.lumo.core.dto.trigger.TriggerEvent;
import lombok.Data;

@Data
public class GithubWebhookEvent implements TriggerEvent {
    private String action;
    private Repository repository;
    private User sender;
    private Issue issue; // nullable for non-issue events

    @Data
    public static class Repository {
        private long id;
        private String name;
        private String full_name;
    }

    @Data
    public static class User {
        private String login;
        private long id;
    }

    @Data
    public static class Issue {
        private long id;
        private String title;
        private String body;
    }
}


