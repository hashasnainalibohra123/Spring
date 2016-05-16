package com.java_blog.SpringBeans;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.entity.User_u;
import com.java_blog.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User_u construct()
	{
		return new  User_u();
	}
	@RequestMapping
	public String register()
	{
		return "register";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User_u user,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return "register";
		}
		System.out.println("Caught");
		userService.save(user);
		
		return "register";
	}
}
