package com.example.sillok_server.domain.post.service;

import com.example.sillok_server.domain.post.domain.Post;
import com.example.sillok_server.domain.post.domain.repository.PostRepository;
import com.example.sillok_server.domain.post.presentation.dto.request.PostRequest;
import com.example.sillok_server.infra.service.S3Service;
import com.example.sillok_server.infra.type.FolderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CreatePostService {

    private final PostRepository postRepository;
    private final S3Service s3Service;

    @Transactional
    public void execute(PostRequest request, MultipartFile image) throws IOException {
        postRepository.save(Post.builder()
                .title(request.getTitle())
                .link(request.getLink())
                .imageUrl(s3Service.uploadImage(image, FolderType.POST_IMAGES))
                .major(request.getMajor())
                .isApproved(false)
            .build());
    }

}