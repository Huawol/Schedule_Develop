package com.example.tododevelop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDto {

    private final int statusCode;
    private final String message;

}
