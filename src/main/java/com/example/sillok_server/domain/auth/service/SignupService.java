package com.example.sillok_server.domain.auth.service;

import com.example.sillok_server.domain.auth.presentation.dto.request.AuthRequest;
import com.example.sillok_server.domain.user.domain.User;
import com.example.sillok_server.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(AuthRequest request) {
        userRepository.save(
                User.builder()
                        .accountId(request.accountId())
                        .password(passwordEncoder.encode(request.password()))
                        .build()
        );
    }
}
