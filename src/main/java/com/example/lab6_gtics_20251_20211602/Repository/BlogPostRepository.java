package com.example.lab6_gtics_20251_20211602.Repository;

import com.example.lab6_gtics_20251_20211602.Entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}