package com.lumo.core.dto.api;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private String redirectUrl;
    private T data;
    private String errorCode;

    public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message) {
        return ResponseEntity.ok(
                ApiResponse.<T>builder()
                        .success(true)
                        .message(message)
                        .data(data)
                        .build()
        );
    }

    public static ResponseEntity<ApiResponse<Void>> success(String message) {
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .success(true)
                        .message(message)
                        .build()
        );
    }

    public static ResponseEntity<ApiResponse<Void>> redirect(String message, String redirectUrl) {
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .success(true)
                        .message(message)
                        .redirectUrl(redirectUrl)
                        .build()
        );
    }

    public static ResponseEntity<ApiResponse<Void>> error(String errorCode, String message) {
        return ResponseEntity.badRequest().body(
                ApiResponse.<Void>builder()
                        .success(false)
                        .message(message)
                        .errorCode(errorCode)
                        .build()
        );
    }
}
