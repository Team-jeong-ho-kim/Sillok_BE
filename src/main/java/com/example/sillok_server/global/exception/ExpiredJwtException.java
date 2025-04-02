package com.example.sillok_server.global.exception;

import com.example.sillok_server.global.error.exception.ErrorCode;
import com.example.sillok_server.global.error.exception.SillokException;

public class ExpiredJwtException extends SillokException {

    public static final SillokException EXCEPTION = new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }

}