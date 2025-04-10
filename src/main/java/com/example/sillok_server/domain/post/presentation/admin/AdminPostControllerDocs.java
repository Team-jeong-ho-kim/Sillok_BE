package com.example.sillok_server.domain.post.presentation.admin;

import com.example.sillok_server.domain.post.presentation.dto.response.PostResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "ADMIN POST API")
public interface AdminPostControllerDocs {

    @Operation(summary = "어드민 글 전체 조회", description = "아직 수락되지 않은 글을 전체조회하는 api 입니당~")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "글 조회 성공!!"),
        @ApiResponse(responseCode = "403", description = "글 조회 권한이 없어요..", content = @Content),
        @ApiResponse(responseCode = "404", description = "글을 찾을 수 없어요..", content = @Content),
        @ApiResponse(responseCode = "500", description = "서버 잘못이다...", content = @Content)
    })
    List<PostResponse> adminQueryPosts();

    @Operation(summary = "어드민 글 수락", description = "추천글이 공개되기 전 어드민의 수락을 거치는데, 어드민이 글을 수락하는 api입니당~")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "글이 수락됨!!"),
        @ApiResponse(responseCode = "403", description = "글 수락 권한이 없어요.."),
        @ApiResponse(responseCode = "404", description = "해당 글을 찾을 수 없어요.."),
        @ApiResponse(responseCode = "500", description = "서버 잘못이다...")
    })
    void adminApprovePost(Long postId);

    @Operation(summary = "어드민 글 삭제", description = "어드민이 글을 삭제하는 api입니당~")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "글 삭제 성공!!"),
        @ApiResponse(responseCode = "403", description = "글 삭제 권한이 없어요.."),
        @ApiResponse(responseCode = "404", description = "글을 찾을 수 없어요.."),
        @ApiResponse(responseCode = "500", description = "서버 잘못이다...")
    })
    void adminDeletePost(Long postId);

}