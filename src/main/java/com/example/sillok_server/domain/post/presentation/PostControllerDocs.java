package com.example.sillok_server.domain.post.presentation;

import com.example.sillok_server.domain.post.presentation.dto.request.PostRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Encoding;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "POST API")
public interface PostControllerDocs {

    @Operation(summary = "추천글 작성", description = "추천글을 작성하는 api입니당~")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "추천글이 작성됨!!!!"),
        @ApiResponse(responseCode = "400", description = "요청형식이 잘못됨ㅠㅠ"),
        @ApiResponse(responseCode = "500", description = "내잘못이다...")})
    void createPost(@RequestBody(content = @Content(encoding = @Encoding(name = "request", contentType = MediaType.APPLICATION_JSON_VALUE)))
                    PostRequest request,

                    @RequestBody(content = @Content(encoding = @Encoding(name = "image", contentType = MediaType.MULTIPART_FORM_DATA_VALUE)))
                    MultipartFile image);

}