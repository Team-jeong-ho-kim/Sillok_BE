package com.example.sillok_server.domain.post.presentation.admin;

import com.example.sillok_server.domain.post.presentation.dto.response.PostResponse;
import com.example.sillok_server.domain.post.service.AdminApprovePostService;
import com.example.sillok_server.domain.post.service.AdminDeletePostService;
import com.example.sillok_server.domain.post.service.AdminQueryPostsService;
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