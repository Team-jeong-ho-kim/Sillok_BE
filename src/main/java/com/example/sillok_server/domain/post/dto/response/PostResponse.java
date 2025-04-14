package com.example.sillok_server.domain.post.dto.response;

import com.example.sillok_server.domain.post.domain.enums.Category;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record PostResponse(

    @Schema(name = "id", description = "추천글 id")
    Long id,

    @Schema(name = "title", description = "추천글 제목")
    String title,

    @Schema(name = "introduction", description = "추천글 소개")
    String introduction,

    @Schema(name = "image_url", description = "추천글 이미지 url")
    String imageUrl,

    @Schema(name = "category", description = "추천글 카테고리")
    Category category,

    @Schema(name = "created_at", description = "추천글 작성일")
    LocalDate createdAt

) {

    @QueryProjection
    public PostResponse(Long id, String title, String introduction, String imageUrl, Category category, LocalDate createdAt) {
        this.id = id;
        this.title = title;
        this.introduction = introduction;
        this.imageUrl = imageUrl;
        this.category = category;
        this.createdAt = createdAt;
    }

}