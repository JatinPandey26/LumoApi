package com.lumo.core.exception;

public class InvalidTriggerPayloadException extends RuntimeException {

    public InvalidTriggerPayloadException() {
        super();
    }

    public InvalidTriggerPayloadException(String message) {
        super(message);
    }

    public InvalidTriggerPayloadException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTriggerPayloadException(Throwable cause) {
        super(cause);
    }
}
