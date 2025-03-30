package com.example.sillok_server.domain.post.presentation.dto.request;

import com.example.sillok_server.domain.post.domain.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PostRequest(

    @NotBlank
    @Size(max = 30)
    String title,

    @NotBlank
    @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", message = "유효한 URL 형식이어야 합니다")
    String link,

    @NotNull
    Category category

) {
}