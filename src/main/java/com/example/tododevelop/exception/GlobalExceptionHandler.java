package com.example.tododevelop.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDto> hadleCustomException(CustomException exception) {
        return new ResponseEntity<>(
                new ErrorDto(
                        exception.getExceptionStatus().getStatusCode(),
                        exception.getExceptionStatus().getMessage()
                ),
                HttpStatusCode.valueOf(
                        exception.getExceptionStatus().getStatusCode()
                )
        );
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity hadleMethodArgumentNotValidException(MethodArgumentNotValidException mexception) {
//        return new ResponseEntity<>(
//                mexception.getBindingResult().getFieldErrors().get(0),
//                mexception.getBindingResult().getFieldErrors().get(0).getField(),
//                mexception.getBindingResult().getFieldErrors().get(0).getDefaultMessage(),
//                HttpStatus.BAD_REQUEST);
//    }
}
