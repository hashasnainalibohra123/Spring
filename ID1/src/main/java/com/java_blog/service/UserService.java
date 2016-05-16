package com.java_blog.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.entity.Blog;
import com.java.entity.Item;
import com.java.entity.Role;
import com.java.entity.User_u;
import com.java_blog.repository.BlogRepository;
import com.java_blog.repository.ItemRepository;
import com.java_blog.repository.RoleRepository;
import com.java_blog.repository.UserRepository;

@Service
@Transactional
public class UserService {
@Autowired
	private  UserRepository userRepository;
@Autowired
private BlogRepository blogRepository;
@Autowired
private ItemRepository itemRepository;
@Autowired
private RoleRepository roleRepository;
public List<User_u> findAll()

{
	return userRepository.findAll();
}

public User_u findone(int id) {
	return userRepository.findOne(id);
	//return null;
}

public User_u findOneWithBlog(int id) {
	
	User_u u1=userRepository.findOne(id);
	List<Blog> blogs=blogRepository.findByUser(u1);
	for(Blog b:blogs)
	{
	List<Item> items=	itemRepository.findByBlog(b,new PageRequest(0, 10,Direction.DESC,"publishedDate" ));
		b.setItem(items);
	}
	u1.setBlogs(blogs);
	u1.setPass("sdfs");
	return u1;			
}

public User_u findOneWithBlog(String id) {
	
	User_u u1=userRepository.findByName(id);
	return findOneWithBlog(u1.getId());
}

public void save(User_u user) {
	user.setEnabled(true);
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	user.setPass(encoder.encode(user.getPass()));
	List<Role> roles =new ArrayList<Role>();

	 roles.add(roleRepository.findByName("ROLE_USER"));
	user.setRoles(roles);
	
	userRepository.save(user);
}

public  void delete(int d) {
	userRepository.delete(d);
	
}
}
