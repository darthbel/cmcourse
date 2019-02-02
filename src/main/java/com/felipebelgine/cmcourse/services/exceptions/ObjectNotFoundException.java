package com.felipebelgine.cmcourse.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    private static final long setrialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
