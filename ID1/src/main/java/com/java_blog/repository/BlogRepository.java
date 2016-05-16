package com.java_blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entity.Blog;
import com.java.entity.User_u;


public interface BlogRepository extends JpaRepository<Blog, Integer> {
	List<Blog> findByUser(User_u user);

}
