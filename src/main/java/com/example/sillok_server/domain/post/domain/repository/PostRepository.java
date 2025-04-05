package com.example.sillok_server.domain.post.domain.repository;

import com.example.sillok_server.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
}