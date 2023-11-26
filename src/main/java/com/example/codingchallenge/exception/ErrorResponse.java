package com.example.codingchallenge.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {
    private String error;
    private String message;
}
