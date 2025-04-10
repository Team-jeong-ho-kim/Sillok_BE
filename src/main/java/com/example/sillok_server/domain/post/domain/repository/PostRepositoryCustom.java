package com.example.sillok_server.domain.post.domain.repository;

import com.example.sillok_server.domain.post.domain.enums.Category;
import com.example.sillok_server.domain.post.dto.response.PostResponse;

import java.util.List;

public interface PostRepositoryCustom {

    List<PostResponse> findAllByIsApprovedTrue();

    List<PostResponse> findAllByCategoryAndIsApprovedTrue(Category category);

    List<PostResponse> findAllByIsApprovedFalse();

}