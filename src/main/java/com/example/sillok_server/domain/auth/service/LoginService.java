package com.example.sillok_server.domain.auth.service;

import com.example.sillok_server.domain.auth.presentation.dto.request.AuthRequest;
import com.example.sillok_server.domain.auth.presentation.dto.response.TokenResponse;
import com.example.sillok_server.domain.user.domain.User;
import com.example.sillok_server.domain.user.domain.repository.UserRepository;
import com.example.sillok_server.domain.user.exception.UserNotFoundException;
import com.example.sillok_server.global.error.exception.ErrorCode;
import com.example.sillok_server.global.error.exception.SillokException;
import com.example.sillok_server.global.security.jwt.JwtProperties;
import com.example.sillok_server.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final JwtProperties jwtProperties;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public TokenResponse execute(AuthRequest request) {
        User user = userRepository.findByAccountId(request.accountId())
            .orElseThrow(() -> new SillokException(ErrorCode.USER_NOT_FOUND));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw UserNotFoundException.EXCEPTION;
        }

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        return TokenResponse.builder()
            .accessToken(jwtTokenProvider.generateAccessToken(request.accountId()))
            .exp(now.plusSeconds(jwtProperties.accessExp()))
            .build();
    }

}