package com.example.sillok_server.domain.post.admin.controller;

import com.example.sillok_server.domain.post.dto.response.PostResponse;
import com.example.sillok_server.domain.post.admin.service.AdminApprovePostService;
import com.example.sillok_server.domain.post.admin.service.AdminDeletePostService;
import com.example.sillok_server.domain.post.admin.service.AdminQueryPostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post/admin")
@RequiredArgsConstructor
public class AdminPostController implements AdminPostControllerDocs {

    private final AdminQueryPostsService adminQueryPostsService;
    private final AdminApprovePostService adminApprovePostService;
    private final AdminDeletePostService adminDeletePostService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostResponse> adminQueryPosts() {
        return adminQueryPostsService.execute();
    }

    @PatchMapping("/{post-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void adminApprovePost(@PathVariable("post-id") Long postId) {
        adminApprovePostService.execute(postId);
    }

    @DeleteMapping("/{post-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void adminDeletePost(@PathVariable("post-id") Long postId) {
        adminDeletePostService.execute(postId);
    }

}