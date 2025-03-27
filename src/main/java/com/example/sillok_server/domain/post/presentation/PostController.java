package com.example.sillok_server.domain.post.presentation;

import com.example.sillok_server.domain.post.presentation.dto.request.PostRequest;
import com.example.sillok_server.domain.post.service.CreatePostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final CreatePostService createPostService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestPart(name = "request") @Valid PostRequest request,
                           @RequestPart(name = "image", required = false) MultipartFile image) throws IOException {
        createPostService.execute(request, image);
    }

}