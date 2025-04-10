package com.example.sillok_server.domain.post.dto.request;

import com.example.sillok_server.domain.post.domain.enums.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public record PostRequest(

    @NotBlank
    @Size(max = 50)
    @Schema(description = "추천글 제목")
    String title,

    @Size(max = 30)
    @Schema(description = "추천글 소개")
    String introduction,

    @NotBlank
    @Schema(description = "추천할 글의 링크")
    @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", message = "유효한 URL 형식이어야 합니다")
    String link,

    @NotNull
    @Schema(description = "추천글 카테고리")
    Category category

) {
}