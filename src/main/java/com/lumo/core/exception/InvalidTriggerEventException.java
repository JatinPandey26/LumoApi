package com.lumo.core.exception;

public class InvalidTriggerEventException extends RuntimeException {

    public InvalidTriggerEventException() {
        super();
    }

    public InvalidTriggerEventException(String message) {
        super(message);
    }

    public InvalidTriggerEventException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTriggerEventException(Throwable cause) {
        super(cause);
    }
}
