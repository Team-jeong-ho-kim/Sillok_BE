package com.example.sillok_server.global.exception;

import com.example.sillok_server.global.error.exception.ErrorCode;
import com.example.sillok_server.global.error.exception.SillokException;

public class InvalidJwtException extends SillokException {

    public static final SillokException EXCEPTION = new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }

}