package com.example.sillok_server.global.security.jwt;

import com.example.sillok_server.domain.user.domain.User;
import com.example.sillok_server.domain.user.domain.repository.UserRepository;
import com.example.sillok_server.global.exception.ExpiredJwtException;
import com.example.sillok_server.global.exception.InvalidJwtException;
import com.example.sillok_server.global.security.auth.AuthDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final UserRepository userRepository;
    private final JwtProperties jwtProperties;
    private final SecretKeySpec secretKeySpec;

    public JwtTokenProvider(UserRepository userRepository, JwtProperties jwtProperties) {
        this.userRepository = userRepository;
        this.jwtProperties = jwtProperties;
        this.secretKeySpec = new SecretKeySpec(jwtProperties.secretKey().getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }

    private String generateToken(String accountId, String type, Long exp) {
        return Jwts.builder()
            .signWith(secretKeySpec)
            .setSubject(accountId)
            .setIssuedAt(new Date())
            .setHeaderParam("type", type)
            .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
            .compact();
    }

    public String generateAccessToken(String accountId) {
        return generateToken(accountId, "access", jwtProperties.accessExp());
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith(jwtProperties.prefix())) {
            return bearerToken.replace(jwtProperties.prefix(), "").trim();
        }
        return null;
    }

    public String resolveToken(HttpServletRequest request) {
        return parseToken(request.getHeader(jwtProperties.header()));
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(secretKeySpec)
                .build()
                .parseClaimsJws(token)
                .getBody();
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw ExpiredJwtException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidJwtException.EXCEPTION;
        }
    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    public Authentication getAuthentication(String token) {
        String accountId = getTokenSubject(token);
        User user = userRepository.findByAccountId(accountId)
            .orElseThrow(() -> new UsernameNotFoundException("해당하는 accountID의 유저를 찾을 수 없음 : " + accountId));

        UserDetails userDetails = new AuthDetails(user);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

}