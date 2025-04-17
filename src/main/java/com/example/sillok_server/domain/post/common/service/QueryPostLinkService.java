package com.example.sillok_server.domain.post.common.service;

import com.example.sillok_server.domain.post.domain.Post;
import com.example.sillok_server.domain.post.domain.repository.PostRepository;
import com.example.sillok_server.domain.post.dto.response.PostLinkResponse;
import com.example.sillok_server.domain.post.exception.PostNotFoundException;
import com.example.sillok_server.domain.traffic.domain.Traffic;
import com.example.sillok_server.domain.traffic.domain.repository.TrafficRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryPostLinkService {

    private final PostRepository postRepository;
    private final TrafficRepository trafficRepository;

    @Transactional
    public PostLinkResponse execute(Long postId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        Traffic traffic = trafficRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Traffic 데이터가 없습니다"));

        traffic.click();

        return new PostLinkResponse(post.getLink());
    }

}