package com.example.sillok_server.infra.exception;

import com.example.sillok_server.global.error.ErrorCode;
import com.example.sillok_server.global.error.SillokException;

public class InvalidImageException extends SillokException {

    public static final SillokException EXCEPTION = new InvalidImageException();

    private InvalidImageException() {
        super(ErrorCode.INVALID_IMAGE);
    }

}