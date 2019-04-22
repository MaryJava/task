package com.beejee.task.exception.handler;

import com.beejee.task.exception.EntityAlreadyExistException;
import com.beejee.task.exception.NoContentFoundException;
import com.beejee.task.exception.error.ErrorDetails;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND);
        errorDetails.setMessage(ex.getMessage());
        return buildResponseEntity(errorDetails);
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityAlreadyExistException ex) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.CONFLICT);
        errorDetails.setMessage(ex.getMessage());
        return buildResponseEntity(errorDetails);
    }

    @ExceptionHandler(NoContentFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(NoContentFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NO_CONTENT);
        errorDetails.setMessage(ex.getMessage());
        return buildResponseEntity(errorDetails);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorDetails errorDetails) {
        return new ResponseEntity<>(errorDetails, errorDetails.getStatus());
    }
}
