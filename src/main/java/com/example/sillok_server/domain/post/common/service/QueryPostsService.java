package com.example.sillok_server.domain.post.common.service;

import com.example.sillok_server.domain.post.domain.repository.PostRepository;
import com.example.sillok_server.domain.post.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryPostsService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostResponse> execute() {
        return postRepository.findAllByIsApprovedTrue();
    }

}