package com.lumo.core.ENUM;

public enum GithubEvent {
    ISSUES("issues"),
    PULL_REQUEST("pull_request"),
    UNKNOWN("unknown");

    private final String eventName;

    GithubEvent(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public static GithubEvent fromString(String name) {
        for (GithubEvent event : values()) {
            if (event.eventName.equalsIgnoreCase(name)) return event;
        }
        return UNKNOWN;
    }
}
