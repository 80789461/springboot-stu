package com.example.demo.secruity.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 登陆成功处理器
 * @author YCKJ1060
 *
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		response.setStatus(HttpStatus.OK.value());
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.getWriter().write(objectMapper.writeValueAsString(authentication));
	}
}
