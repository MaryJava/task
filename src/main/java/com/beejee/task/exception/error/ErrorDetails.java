package com.beejee.task.exception.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorDetails {

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    private ErrorDetails() {
        timestamp = LocalDateTime.now();
    }

    public ErrorDetails(HttpStatus status) {
        this();
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
