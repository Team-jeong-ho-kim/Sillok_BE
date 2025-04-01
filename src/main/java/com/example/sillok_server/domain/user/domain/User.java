package com.example.sillok_server.domain.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Entity(name = "tbl_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String accountId;

    @Column(nullable = false, columnDefinition = "CHAR(60)")
    private String password;

}