package com.example.demo.controller;

import com.example.demo.dao.ErrorDTO;
import com.example.demo.exception.BussinessException;
import com.example.demo.exception.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(RuntimeException ex) {

        ErrorDTO error = ErrorDTO.builder().code("P-500").message(ex.getMessage()).build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestException ex) {

        ErrorDTO error = ErrorDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BussinessException.class)
    public ResponseEntity<ErrorDTO> businessExceptionHandler(BussinessException ex) {

        ErrorDTO error = ErrorDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();

        return new ResponseEntity<>(error, ex.getStatus());
    }
}
