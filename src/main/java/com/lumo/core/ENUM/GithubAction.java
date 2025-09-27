package com.lumo.core.ENUM;

public enum GithubAction {
    OPENED("opened"),
    EDITED("edited"),
    CLOSED("closed"),
    UNKNOWN("unknown");

    private final String action;

    GithubAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public static GithubAction fromString(String action) {
        for (GithubAction a : values()) {
            if (a.action.equalsIgnoreCase(action)) return a;
        }
        return UNKNOWN;
    }
}
