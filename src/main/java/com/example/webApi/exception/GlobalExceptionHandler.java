package com.example.webApi.exception;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // Hanterar Springs @Valid exception.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return errors;
    }

    // Hanterar Javas IllegalArgumentException som throwas i AdditionRequest2 constructorn.
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> handleIllegalArgumentExceptions(IllegalArgumentException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", e.getMessage());
        return errors;
    }

    // Hanterar Javas NullPointerException som throwas i AdditionRequest3 av Lambok's @NonNull.
    @ExceptionHandler(NullPointerException.class)
    public Map<String, String> handleNullPoExceptions(NullPointerException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", e.getMessage());
        return errors;
    }
}
