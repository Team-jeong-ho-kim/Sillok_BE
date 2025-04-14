package com.example.sillok_server.domain.auth.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.ZonedDateTime;

@Builder
public record TokenResponse(

    @Schema(name = "access_token", description = "액세스 토큰")
    String accessToken,

    @Schema(name = "exp", description = "만료 기간")
    ZonedDateTime exp
) {
}