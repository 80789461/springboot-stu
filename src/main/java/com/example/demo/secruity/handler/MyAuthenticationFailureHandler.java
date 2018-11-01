package com.example.demo.secruity.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 登陆失败处理器
 * @author YCKJ1060
 *
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
	@Autowired
	ObjectMapper objectMapper;
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setStatus(HttpStatus.OK.value());
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		Result<Object> result = Result.fail("400", exception.getLocalizedMessage());
		response.getWriter().write(objectMapper.writeValueAsString(result));

	}
}
