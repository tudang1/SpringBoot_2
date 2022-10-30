package com.example.userbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {
    // Xử lý BadRequestException
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestexception(BadRequestException e) {
        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    // Xử lý NotFoundException
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException e) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    // Xử lý các exception còn lại
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e) {
        ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
