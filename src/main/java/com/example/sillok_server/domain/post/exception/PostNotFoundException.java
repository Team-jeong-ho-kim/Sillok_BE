package com.example.sillok_server.domain.post.exception;

import com.example.sillok_server.global.error.exception.ErrorCode;
import com.example.sillok_server.global.error.exception.SillokException;

public class PostNotFoundException extends SillokException {

    public static final SillokException EXCEPTION = new PostNotFoundException();

    private PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }

}