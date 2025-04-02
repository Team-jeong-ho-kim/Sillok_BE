package com.example.sillok_server.domain.auth.presentation.dto.response;

import lombok.Builder;

import java.time.ZonedDateTime;

@Builder
public record TokenResponse(
    String accessToken,
    ZonedDateTime exp
) {
}