package com.example.sillok_server.domain.post.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record PostLinkResponse(

    @Schema(description = "포스트 링크")
    String link

) {
}