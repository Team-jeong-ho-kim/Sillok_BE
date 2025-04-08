package com.example.sillok_server.domain.post.presentation;

import com.example.sillok_server.domain.post.domain.enums.Category;
import com.example.sillok_server.domain.post.presentation.dto.request.PostRequest;
import com.example.sillok_server.domain.post.presentation.dto.response.PostResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Encoding;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "POST API")
public interface PostControllerDocs {

    @Operation(summary = "추천글 작성", description = "추천글을 작성하는 api입니당~")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "추천글이 작성됨!!!!"),
        @ApiResponse(responseCode = "400", description = "요청형식이 잘못됨ㅠㅠ"),
        @ApiResponse(responseCode = "500", description = "서버 잘못이다...")})
    void createPost(@RequestBody(content = @Content(encoding = @Encoding(name = "request", contentType = MediaType.APPLICATION_JSON_VALUE)))
                    PostRequest request,

                    @RequestBody(content = @Content(encoding = @Encoding(name = "image", contentType = MediaType.MULTIPART_FORM_DATA_VALUE)))
                    MultipartFile image);

    @Operation(summary = "글 전체 조회", description = "글 전체조회 api입니당~")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "글 조회 성공!!"),
        @ApiResponse(responseCode = "404", description = "글을 찾을 수 없어요..", content = @Content),
        @ApiResponse(responseCode = "500", description = "서버 잘못이다...", content = @Content)})
    @Parameter(name = "category", description = "조회할 카테고리 선택")
    List<PostResponse> queryPosts(Category category);

    @Operation(summary = "어드민 글 전체 조회", description = "아직 수락되지 않은 글을 전체조회하는 api 입니당~")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "글 조회 성공!!"),
        @ApiResponse(responseCode = "403", description = "글 조회 권한이 없어요..", content = @Content),
        @ApiResponse(responseCode = "404", description = "글을 찾을 수 없어요..", content = @Content),
        @ApiResponse(responseCode = "500", description = "서버 잘못이다...", content = @Content)
    })
    List<PostResponse> adminQueryPosts();

}