package com.example.demo.secruity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
/**
 * 资源服务器配置
 * @author tianyuan
 *
 */
@Configuration
@EnableResourceServer
public class MyResourceServer extends ResourceServerConfigurerAdapter {
	private String DEMO_RESOURCE_ID = "hello";
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http.requestMatchers().antMatchers("/api/**")
         .and()      
         .authorizeRequests()
         .antMatchers("/api/**").authenticated();
	}
}
