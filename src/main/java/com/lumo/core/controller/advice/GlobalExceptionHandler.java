package com.lumo.core.controller.advice;

import com.lumo.core.dto.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ApiResponse<Object> handleRuntime(RuntimeException ex) {
//        ex.printStackTrace();
//        return buildResponse(ex);
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ApiResponse<Object> handleOther(Exception ex) {
//        ex.printStackTrace();
//        return buildResponse(ex);
//    }
//
//    private ApiResponse<Object> buildResponse(Exception ex) {
//        try {
//            return ApiResponse.builder()
//                    .success(false)
//                    .message(ex.getMessage())
//                    .errorCode("INTERNAL_ERROR")
//                    .build();
//        } catch (Exception innerEx) {
//            // fallback: prevent infinite loop
//            innerEx.printStackTrace();
//            return  ApiResponse.builder().message("Internal Error").success(false).build();
//        }
//    }

}

