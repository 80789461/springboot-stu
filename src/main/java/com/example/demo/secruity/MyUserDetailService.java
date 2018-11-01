package com.example.demo.secruity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.controller.form.UserForm;
/**
 * 自定义用户查询
 * @author YCKJ1060
 *
 */
@Service
public class MyUserDetailService implements UserDetailsService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.debug("查找用户。。。。。。。。。。。。。。。。。。。");
		UserForm user = findUser(username);
		if (user==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new User(user.getName(), user.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("ADMIN"));
	}
	//模拟从数据库查询数据
	public UserForm  findUser(String username) {
		UserForm user = new UserForm();
		user.setId("111");
		user.setName("admin");
		user.setPassword(passwordEncoder.encode("123456"));
		return user;
	}
}
