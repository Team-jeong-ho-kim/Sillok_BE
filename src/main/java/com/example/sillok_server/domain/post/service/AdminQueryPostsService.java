package com.example.sillok_server.domain.post.service;

import com.example.sillok_server.domain.post.domain.repository.PostRepository;
import com.example.sillok_server.domain.post.presentation.dto.response.PostResponse;
import com.example.sillok_server.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminQueryPostsService {

    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<PostResponse> execute() {
        userFacade.getCurrentUser();
        return postRepository.findAllByIsApprovedFalse();
    }

}