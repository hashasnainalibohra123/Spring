package com.java_blog.SpringBeans;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.entity.Blog;

import com.java_blog.service.BlogService;
import com.java_blog.service.UserService;


@Controller
public class UserController {


	@ModelAttribute("blog")
	public Blog constructBlog()
	{
		return new  Blog();
	}
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/account")
	public String account (Model m,Principal principal)
	{
		String name=principal.getName();
		m.addAttribute("user", userService.findOneWithBlog(name));
		return "account";
	}
	@RequestMapping(value="/account",method=RequestMethod.POST)
	public String doAddBlog(@Valid @ModelAttribute("blog") Blog blog,Principal principal,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return "account";
		}
		String name=principal.getName();
		System.out.println(name+" asdsfsfsfs");
		blogService.save(blog,name);
		return "redirect:/ account";
	}
	
	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id)
	{
		Blog blog=blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account";
	}
	
	
}
