package com.example.demo.secruity.exception;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

public class MyException extends OAuth2Exception {

	public MyException(String msg) {
		super(msg);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

}
