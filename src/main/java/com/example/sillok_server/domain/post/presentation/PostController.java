package com.example.sillok_server.domain.post.presentation;

import com.example.sillok_server.domain.post.presentation.dto.request.PostRequest;
import com.example.sillok_server.domain.post.service.CreatePostService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Encoding;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController implements PostControllerDocs {

    private final CreatePostService createPostService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestPart(name = "request") @Valid PostRequest request,
                           @RequestPart(name = "image") MultipartFile image) {
        createPostService.execute(request, image);
    }

}