package dev_diary_app_backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dev_diary_app_backend.exceptions.BadRequestException;
import dev_diary_app_backend.exceptions.NotFoundException;

@ControllerAdvice
public class TaskControllerAdvice extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> TaskNotFoundException(NotFoundException err) {
        return new ResponseEntity<>(err.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> TaskBadRequestException(NotFoundException err) {
        return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
