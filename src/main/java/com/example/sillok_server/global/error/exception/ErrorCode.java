package com.example.sillok_server.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),

    // image
    IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "Image Not Found"),
    INVALID_IMAGE(HttpStatus.BAD_REQUEST, "Invalid Image"),
    DELETE_IMAGE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Failed Delete Image");

    private final HttpStatus status;
    private final String message;

}