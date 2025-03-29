package com.example.sillok_server.domain.post.presentation.dto.request;

import com.example.sillok_server.domain.post.domain.Major;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostRequest(

    @NotBlank
    @Size(max = 30)
    String title,

    @NotBlank
    String link,

    @NotNull
    Major major

) {
}