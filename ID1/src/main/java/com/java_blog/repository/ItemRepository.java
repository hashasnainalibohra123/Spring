package com.java_blog.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entity.Blog;
import com.java.entity.Item;


public interface ItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findByBlog(Blog blog,Pageable pageable);

}
