package com.example.sillok_server.domain.post.common.controller;

import com.example.sillok_server.domain.post.common.service.CreatePostService;
import com.example.sillok_server.domain.post.common.service.QueryPostLinkService;
import com.example.sillok_server.domain.post.common.service.QueryPostsByCategoryService;
import com.example.sillok_server.domain.post.common.service.QueryPostsService;
import com.example.sillok_server.domain.post.domain.enums.Category;
import com.example.sillok_server.domain.post.dto.request.PostRequest;
import com.example.sillok_server.domain.post.dto.response.PostLinkResponse;
import com.example.sillok_server.domain.post.dto.response.PostResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController implements PostControllerDocs {

    private final CreatePostService createPostService;
    private final QueryPostsService queryPostsService;
    private final QueryPostsByCategoryService queryPostsByCategoryService;
    private final QueryPostLinkService queryPostLinkService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestPart(name = "request") @Valid PostRequest request,
                           @RequestPart(name = "image") MultipartFile image) {
        createPostService.execute(request, image);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostResponse> queryPosts(@RequestParam(required = false) Category category) {
        if (category != null) {
            return queryPostsByCategoryService.execute(category);
        }
        return queryPostsService.execute();
    }

    @GetMapping("/{post-id}")
    @ResponseStatus(HttpStatus.OK)
    public PostLinkResponse queryLink(@PathVariable("post-id") Long postId) {
        return queryPostLinkService.execute(postId);
    }

}