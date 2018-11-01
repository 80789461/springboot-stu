package com.example.demo.secruity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 自定义安全认证
 * @author YCKJ1060
 *
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	MyUserDetailService  myUserDetailService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String password = (String)authentication.getCredentials();
		String userName = (String)authentication.getPrincipal();
		//查找用户
		UserDetails user = myUserDetailService.loadUserByUsername(userName);
		//输入密码和用户密码比较
		if (!passwordEncoder.matches(password, user.getPassword())) {
			throw new BadCredentialsException("用户名密码不正确，请重新登陆！");
		}
        return new UsernamePasswordAuthenticationToken(userName, password, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
