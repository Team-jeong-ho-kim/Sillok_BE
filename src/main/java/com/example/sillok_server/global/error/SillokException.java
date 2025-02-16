package com.example.sillok_server.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SillokException extends RuntimeException {

    private final ErrorCode errorCode;

}