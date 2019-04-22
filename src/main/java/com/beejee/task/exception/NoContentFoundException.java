package com.beejee.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NoContentFoundException extends RuntimeException {

    public NoContentFoundException(final String message) {
        super(message);
    }
}
