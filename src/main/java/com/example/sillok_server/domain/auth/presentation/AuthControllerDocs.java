package com.example.sillok_server.domain.auth.presentation;

import com.example.sillok_server.domain.auth.presentation.dto.request.AuthRequest;
import com.example.sillok_server.domain.auth.presentation.dto.response.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "AUTH API")
public interface AuthControllerDocs {

    @Operation(summary = "로그인", description= "어드민만 가능한 로그인 api 입니당~")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "로그인 성공!!!!!!", content = @Content(schema = @Schema(implementation = TokenResponse.class))),
        @ApiResponse(responseCode = "401", description = "비밀번호 틀렸다잉", content = @Content),
        @ApiResponse(responseCode = "400", description = "형식이 잘못됐어!!!!!!!!!", content = @Content),
        @ApiResponse(responseCode = "500", description = "서버 탓이다...", content = @Content)
    })
    TokenResponse login(@RequestBody AuthRequest request);

}