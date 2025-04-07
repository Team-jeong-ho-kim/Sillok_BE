package com.example.sillok_server.domain.post.domain.repository;

import com.example.sillok_server.domain.post.domain.enums.Category;
import com.example.sillok_server.domain.post.presentation.dto.response.PostResponse;

import java.util.List;

public interface PostRepositoryCustom {

    List<PostResponse> findAllByIsApprovedTrue();

    List<PostResponse> findAllByCategoryAndIsApprovedTrue(Category category);

}