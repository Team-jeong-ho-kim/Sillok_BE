package com.example.sillok_server.domain.post.domain.repository;

import com.example.sillok_server.domain.post.domain.QPost;
import com.example.sillok_server.domain.post.domain.enums.Category;
import com.example.sillok_server.domain.post.presentation.dto.response.PostResponse;
import com.example.sillok_server.domain.post.presentation.dto.response.QPostResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QPost post = QPost.post;

    @Override
    public List<PostResponse> findAllByIsApprovedTrue() {
        return queryFactory
            .select(new QPostResponse(
                post.id,
                post.title,
                post.imageUrl,
                post.category,
                post.createdAt
            ))
            .from(post)
            .where(post.isApproved.eq(true))
            .orderBy(post.createdAt.desc())
            .fetch();
    }

    @Override
    public List<PostResponse> findAllByCategoryAndIsApprovedTrue(Category category) {
        return queryFactory
            .select(new QPostResponse(
                post.id,
                post.title,
                post.imageUrl,
                post.category,
                post.createdAt
            ))
            .from(post)
            .where(post.category.eq(category).and(post.isApproved.eq(true)))
            .orderBy(post.createdAt.desc())
            .fetch();
    }

}