package com.java_blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.java.entity.Blog;
import com.java.entity.User_u;
import com.java_blog.repository.BlogRepository;
import com.java_blog.repository.UserRepository;
@Service
public class BlogService {
@Autowired
BlogRepository blogRepository;
@Autowired
UserRepository userRepository;

	public void save(Blog blog, String name) {
User_u u=userRepository.findByName(name);
blog.setUser(u);
blogRepository.save(blog);

	}
@PreAuthorize("#d.user.name==authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("d") Blog d) {
		blogRepository.delete(d);
		
	}

	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}

}
