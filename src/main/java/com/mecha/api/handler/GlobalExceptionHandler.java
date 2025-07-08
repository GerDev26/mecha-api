package com.mecha.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mecha.api.dto.api.ApiExceptionDTO;
import com.mecha.api.exceptions.NotFoundException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiExceptionDTO> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ApiExceptionDTO apiExceptionDTO = new ApiExceptionDTO("Validation error", errors);

        return new ResponseEntity<>(apiExceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiExceptionDTO> handleException(NotFoundException ex) {
        ApiExceptionDTO apiExceptionDTO = new ApiExceptionDTO("Not founded", ex.getMessage());
        return new ResponseEntity<>(apiExceptionDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiExceptionDTO> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex) {
        ApiExceptionDTO apiExceptionDTO = new ApiExceptionDTO(
            "Method not allowed",
            ex.getMessage()
        );
        return new ResponseEntity<>(apiExceptionDTO, HttpStatus.METHOD_NOT_ALLOWED);
    }

    // Puedes capturar otras excepciones también
    // @ExceptionHandler(YourCustomException.class)
    // public ResponseEntity<String> handleCustomException(...) { ... }
}
