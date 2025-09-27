package com.lumo.core.exception;

public class TriggerTypeMismatchException extends RuntimeException{

    public TriggerTypeMismatchException() {
        super();
    }

    public TriggerTypeMismatchException(String message) {
        super(message);
    }

    public TriggerTypeMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriggerTypeMismatchException(Throwable cause) {
        super(cause);
    }

}
