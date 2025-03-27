package com.example.sillok_server.domain.post.presentation.dto.request;

import com.example.sillok_server.domain.post.domain.Major;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequest {

    @NotBlank
    @Size(max = 30)
    private String title;

    @NotBlank
    private String link;

    @NotNull
    private Major major;

}