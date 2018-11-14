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

import com.example.demo.common.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
/**
 * token异常返回
 * @author YCKJ1060
 *
 */
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		 
		 response.setContentType("application/json;charset=UTF-8");
         response.setContentType("application/json");
         response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
         response.getWriter().write(objectMapper.writeValueAsString(Result.fail("401", authException.getMessage())));
	}

}
