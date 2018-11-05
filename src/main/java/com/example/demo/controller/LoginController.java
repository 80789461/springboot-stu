package com.example.demo.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Result;

@Controller
public class LoginController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/")
	public Result<String> index() {
	    return Result.sucess("成功");
	}
	 
	@RequestMapping("/hello")
	public String hello() {
		
	    return "hello";
	}
	 
	@RequestMapping("/login")
	public String login() {
	    return "login";
	}
	@RequestMapping("/test")
	public String test() {
	    return "来";
	}
}