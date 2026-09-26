package com.example.tracker.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskException.class)
    public ResponseEntity<ErrorObject> taskException(TaskException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorObject.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .errorTime(LocalDateTime.now())
                .build());
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorObject> exceptions(Throwable exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorObject.builder()
                .statusCode(HttpStatus.SERVICE_UNAVAILABLE.value())
                .message(exception.getMessage())
                .errorTime(LocalDateTime.now())
                .build());
    }
}
