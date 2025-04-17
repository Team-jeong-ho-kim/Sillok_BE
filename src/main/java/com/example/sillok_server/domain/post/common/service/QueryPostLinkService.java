package com.example.sillok_server.domain.post.common.service;

import com.example.sillok_server.domain.post.domain.Post;
import com.example.sillok_server.domain.post.domain.repository.PostRepository;
import com.example.sillok_server.domain.post.dto.response.PostLinkResponse;
import com.example.sillok_server.domain.post.exception.PostNotFoundException;
import com.example.sillok_server.domain.traffic.domain.Traffic;
import com.example.sillok_server.domain.traffic.domain.repository.TrafficRepository;
import com.example.sillok_server.domain.traffic.service.TrafficService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryPostLinkService {

    private final PostRepository postRepository;
    private final TrafficService trafficService;

    @Transactional
    public PostLinkResponse execute(Long postId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        
        return new PostLinkResponse(post.getLink());
    }

}