package com.example.demo.secruity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
/**
 * 资源服务器配置
 * @author tianyuan
 *
 */
@Configuration
@EnableResourceServer
public class MyResourceServer extends ResourceServerConfigurerAdapter {
	
	@Autowired
	AccessDeniedHandler myAccessDeniedHandler;
	@Autowired
	AuthenticationEntryPoint  myAuthenticationEntryPoint;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http.requestMatchers().antMatchers("/api/**")
         .and()      
         .authorizeRequests()
         .antMatchers("/api/**").authenticated();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(resources);
		resources.accessDeniedHandler(myAccessDeniedHandler).authenticationEntryPoint(myAuthenticationEntryPoint);
		
	}
}
