package com.lumo.core.controller.advice;

import com.lumo.core.dto.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Object> handleAllExceptions(Exception ex) {
        ex.printStackTrace();

        return ApiResponse.builder()
                .success(false)
                .message(ex.getMessage())
                .errorCode("INTERNAL_ERROR")
                .build();
    }

}

