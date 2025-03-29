package com.example.sillok_server.infra.exception;

import com.example.sillok_server.global.error.exception.ErrorCode;
import com.example.sillok_server.global.error.exception.SillokException;

public class ImageNotFoundException extends SillokException {

    public static final SillokException EXCEPTION = new ImageNotFoundException();

    private ImageNotFoundException() {
        super(ErrorCode.IMAGE_NOT_FOUND);
    }

}