package com.lumo.core.controller.advice;

import com.lumo.core.dto.api.ApiResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class GlobalResponseWrapper implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // Apply to all controllers
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        // If already an ApiResponse, return as-is
        if (body instanceof ApiResponse) {
            return body;
        }

        // Wrap non-ApiResponse body
        return ApiResponse.builder()
                .success(true)
                .data(body)
                .message(null)
                .redirectUrl(null)
                .errorCode(null)
                .build();
    }
}
