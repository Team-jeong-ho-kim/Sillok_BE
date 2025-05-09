package com.example.sillok_server.domain.post.domain;

import com.example.sillok_server.domain.post.domain.enums.Category;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Builder
@Entity(name = "tbl_post")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String title;

    @Column(nullable = true, columnDefinition = "VARCHAR(30)")
    private String introduction;

    @Column(nullable = false, columnDefinition = "VARCHAR(512)")
    private String link;

    @Column(nullable = false, columnDefinition = "VARCHAR(150)")
    private String imageUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private boolean isApproved;

    public void approve() {
        this.isApproved = true;
    }

}