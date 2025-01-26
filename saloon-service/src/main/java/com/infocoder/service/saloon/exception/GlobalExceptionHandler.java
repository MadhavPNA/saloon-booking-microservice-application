package com.infocoder.service.saloon.exception;

import com.infocoder.service.saloon.payload.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SaloonNotFoundException.class)
    public ResponseEntity<ExceptionResponse> SaloonNotFoundExceptionHandler(Exception ex, WebRequest req) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getMessage(),
                req.getDescription(false),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> exceptionHandler(Exception ex, WebRequest req) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getMessage(),
                req.getDescription(false),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
