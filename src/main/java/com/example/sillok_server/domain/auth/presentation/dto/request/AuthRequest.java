package com.example.sillok_server.domain.auth.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthRequest(

    @NotBlank
    @Size(max = 10)
    @Schema(description = "계정 아이디")
    String accountId,

    @NotBlank
    @Size(max = 20)
    @Schema(description = "계정 비밀번호")
    String password

) {
}