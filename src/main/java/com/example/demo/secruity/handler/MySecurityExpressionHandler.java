package com.example.demo.secruity.handler;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

public class MySecurityExpressionHandler implements SecurityExpressionHandler<FilterInvocation> {

	@Override
	public ExpressionParser getExpressionParser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EvaluationContext createEvaluationContext(Authentication authentication, FilterInvocation invocation) {
		// TODO Auto-generated method stub
		return null;
	}

}
