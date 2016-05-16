package com.java_blog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.transaction.Transactional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
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
@Transactional
@Service
public class InitDBService {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private ItemRepository itemRepository;


@PostConstruct
public void init()
{
	Role roleUser=new Role();
	roleUser.setName("ROLE_USER");
	roleRepository.save(roleUser);
	
	Role roleAdmin=new Role();
	roleAdmin.setName("ROLE_ADMIN");
	roleRepository.save(roleAdmin);
	
	User_u userAdmin =new User_u();
	 userAdmin.setName("admin");
	 BCryptPasswordEncoder encorder=new BCryptPasswordEncoder();
	 userAdmin.setPass(encorder.encode("admin"));
	 userAdmin.setEnabled(true);
	 List<Role> roles =new ArrayList<Role>();
	 roles.add(roleAdmin);
	 roles.add(roleUser);
	 userAdmin.setEmail("sdfsf@gmail.com");
	 userAdmin.setRoles(roles);
	 userRepository.save(userAdmin);
	 
	 Blog javaVids=new Blog();
	 javaVids.setName("Java Vids");
	 javaVids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
	 javaVids.setUser(userAdmin);
	 blogRepository.save(javaVids);
	 
	 Item item=new Item();
	 item.setBlog(javaVids);
	 item.setName("First");
	 item.setLink("http://www.javavids.com/");
	 item.setPublishedDate(new Date());
	 itemRepository.save(item);
	 Item item2=new Item();
	 item2.setBlog(javaVids);
	 item2.setName("First");
	 item2.setLink("http://www.javavids.com/");
	 item2.setPublishedDate(new Date());
	 itemRepository.save(item2);
	 System.out.println("callewd");
}

}
