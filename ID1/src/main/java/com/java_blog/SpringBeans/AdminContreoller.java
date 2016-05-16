package com.java_blog.SpringBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java_blog.service.UserService;

@Controller
@RequestMapping("/users")
public class AdminContreoller {
	@Autowired
	private UserService userService;
	@RequestMapping
	public String  users(Model model)
	{
		model.addAttribute("users",userService.findAll());
		return "users";	 
	}
	@RequestMapping("/{id}")
	public String details (Model m,@PathVariable int id)
	{
		m.addAttribute("user", userService.findOneWithBlog(id));
		return "user_detail";
	}
	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable int id)
	{
		userService.delete(id);
		return "redirect:/users.html";
	}

}
