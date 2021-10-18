package com.treasureio.line.exception;

import com.treasureio.line.models.Check;

import java.util.List;

public class CheckNotFoundException extends Exception{
    public CheckNotFoundException() {
        super();
    }

    public CheckNotFoundException(String message) {
        super(message);
    }

    public CheckNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CheckNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
