package com.example.sillok_server.domain.post.common.service;

import com.example.sillok_server.domain.post.domain.Post;
import com.example.sillok_server.domain.post.domain.repository.PostRepository;
import com.example.sillok_server.domain.post.dto.request.PostRequest;
import com.example.sillok_server.domain.traffic.domain.Traffic;
import com.example.sillok_server.domain.traffic.domain.repository.TrafficRepository;
import com.example.sillok_server.infra.exception.InvalidImageException;
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
    private final TrafficRepository trafficRepository;

    @Transactional
    public void execute(PostRequest request, MultipartFile image) {
        String imageUrl = null;
        try {
            imageUrl = s3Service.uploadImage(image, FolderType.POST_IMAGES);
        } catch (IOException e) {
            throw InvalidImageException.EXCEPTION;
        }

        Traffic traffic = trafficRepository.findById(1L)
                .orElseGet(() -> {
                    Traffic newTraffic = new Traffic();
                    return trafficRepository.save(newTraffic);
                });

        traffic.create();

        postRepository.save(Post.builder()
                .title(request.title())
                .introduction(request.introduction())
                .link(request.link())
                .imageUrl(imageUrl)
                .category(request.category())
                .isApproved(false)
            .build());
    }

}