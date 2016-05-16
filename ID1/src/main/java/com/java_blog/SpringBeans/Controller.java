package com.java_blog.SpringBeans;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
@RequestMapping("/index")
public String getIndex()
{
	return "index";
}
}
