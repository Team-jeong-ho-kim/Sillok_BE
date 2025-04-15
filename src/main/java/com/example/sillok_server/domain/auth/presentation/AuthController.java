package com.example.sillok_server.domain.auth.presentation;

import com.example.sillok_server.domain.auth.presentation.dto.request.AuthRequest;
import com.example.sillok_server.domain.auth.presentation.dto.response.TokenResponse;
import com.example.sillok_server.domain.auth.service.LoginService;
import com.example.sillok_server.domain.auth.service.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController implements AuthControllerDocs{

    private final LoginService loginService;
    private final SignupService signupService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse login(@RequestBody @Valid AuthRequest request) {
        return loginService.execute(request);
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid AuthRequest request) {
        signupService.execute(request);
    }

}