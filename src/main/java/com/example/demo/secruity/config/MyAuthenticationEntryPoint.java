package com.example.demo.secruity.config;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		 
		 response.setContentType("application/json;charset=UTF-8");
         Map<String,String> map = new HashMap<>();
         map.put("error", "400");
         map.put("message", authException.getMessage());
         map.put("path", request.getServletPath());
         map.put("timestamp", String.valueOf(new Date().getTime()));
         response.setContentType("application/json");
         response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
         response.getWriter().write(objectMapper.writeValueAsString(map));
	}

}
