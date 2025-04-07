package com.example.sillok_server.domain.post.domain.repository;

import com.example.sillok_server.domain.post.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long>, PostRepositoryCustom {
}