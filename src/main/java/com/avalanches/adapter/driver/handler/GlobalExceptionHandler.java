package com.avalanches.adapter.driver.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorDetails>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ValidationErrorDetails> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ValidationErrorDetails(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
