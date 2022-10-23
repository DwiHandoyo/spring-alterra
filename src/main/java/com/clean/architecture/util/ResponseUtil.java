package com.clean.architecture.util;

import com.clean.architecture.constant.AppConstant.ResponseCode;
import com.clean.architecture.domain.common.ApiResponse;
import com.clean.architecture.domain.common.ApiResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ResponseUtil {

    private ResponseUtil() {}

    public static <T> ResponseEntity<Object> build(ResponseCode responseCode, T data, HttpStatus httpStatus) {
        return new ResponseEntity<>(build(responseCode, data), httpStatus);
    }

    private static <T> ApiResponse<T> build(ResponseCode responseCode, T data) {
        return ApiResponse.<T>builder()
            .status(ApiResponseStatus.builder()
                .code(responseCode.getCode())
                .message(responseCode.getMessage())
                .build())
            .timestamp(LocalDateTime.now())
            .data(data)
            .build();
    }
    
    
}
