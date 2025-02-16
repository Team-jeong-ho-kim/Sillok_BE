package com.example.sillok_server.infra.exception;

import com.example.sillok_server.global.error.ErrorCode;
import com.example.sillok_server.global.error.SillokException;

public class DeleteImageFailedException extends SillokException {

    public static final SillokException EXCEPTION = new DeleteImageFailedException();

    private DeleteImageFailedException() {
        super(ErrorCode.DELETE_IMAGE_FAILED);
    }

}