package com.example.todolistbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {
    //xử lý BadrequestException
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException e){
        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST,e.getMessage());
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException e){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }
    //xử lý các lỗi còn lại
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e){
        ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
