package com.example.sillok_server.domain.post.admin.service;

import com.example.sillok_server.domain.post.domain.Post;
import com.example.sillok_server.domain.post.domain.repository.PostRepository;
import com.example.sillok_server.domain.post.exception.PostNotFoundException;
import com.example.sillok_server.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminApprovePostService {

    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long postId) {
        userFacade.getCurrentUser();
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        post.approve();
    }

}