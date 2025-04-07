package com.example.sillok_server.domain.post.presentation.dto.response;

import com.example.sillok_server.domain.post.domain.enums.Category;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record PostResponse(

    @Schema(description = "포스트 id")
    Long id,

    @Schema(description = "포스트 제목")
    String title,

    @Schema(description = "포스트 이미지 url")
    String imageUrl,

    @Schema(description = "포스트 카테고리")
    Category category,

    @Schema(description = "포스트 작성일")
    LocalDate createdAt

) {

    @QueryProjection
    public PostResponse(Long id, String title, String imageUrl, Category category, LocalDate createdAt) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.category = category;
        this.createdAt = createdAt;
    }

}