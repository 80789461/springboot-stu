package com.example.demo.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/")
	public String index() {
	    return "index";
	}
	 
	@RequestMapping("/hello")
	public String hello() {
		
	    return "hello";
	}
	 
	@RequestMapping("/login")
	public String login() {
	    return "login";
	}
}