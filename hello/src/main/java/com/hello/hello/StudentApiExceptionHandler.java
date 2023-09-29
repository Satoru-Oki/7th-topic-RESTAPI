package com.hello.hello;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class StudentApiExceptionHandler {

    public static final class ErrorResponse {
        private final HttpStatus status;
        private final String message;
        private final List<Map<String, String>> errors;

        public ErrorResponse(HttpStatus status, String message, List<Map<String, String>> errors) {
            this.status = status;
            this.message = message;
            this.errors = errors;
        }

        public HttpStatus getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public List<Map<String, String>> getErrors() {
            return errors;
        }
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        List<Map<String, String>> errors = new ArrayList<>();
        for (var violation : ex.getConstraintViolations()) {
            errors.add(Map.of("key", violation.getPropertyPath().toString(), "message", violation.getMessage()));
        }
        ErrorResponse errorResponse =
                new ErrorResponse(HttpStatus.BAD_REQUEST, "validation error", errors);
        return ResponseEntity.badRequest().body(errorResponse);
    }
}

