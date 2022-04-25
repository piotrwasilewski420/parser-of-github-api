package com.piotrwasilewski420.allegrosummerexperience2022.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvisor {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(WebClientResponseException.class)
    protected ApiError handleWebClientResponseException(WebClientResponseException exception){
        ApiError error = new ApiError();
        error.setMessageName(exception.getMessage());
        return error;
    }
}
