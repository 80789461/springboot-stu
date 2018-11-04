package com.example.demo.secruity;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 自定义登陆验证
	 */
	@Autowired
	AuthenticationProvider myAuthenticationProvider;
	
	/**
	 * 自定义登陆成功处理器
	 */
	@Autowired
	AuthenticationSuccessHandler myAuthenticationSuccessHandler;
	/**
	 * 自定义登陆失败处理
	 */
	@Autowired
	AuthenticationFailureHandler myAuthenticationFailureHandler;
	
	@Autowired
	AccessDecisionManager myAccessDecisionManager;
	
	  @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new PasswordEncoder() {
	            @Override
	            public String encode(CharSequence charSequence) {
	                return charSequence.toString();
	            }
	 
	            @Override
	            public boolean matches(CharSequence charSequence, String s) {
	                return Objects.equals(charSequence.toString(),s);
	            }
	        };
	  }
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	      http
	      		//定义哪些url需要保护，哪些url不需要保护
	          .authorizeRequests() 
	              .antMatchers("/", "/message/").permitAll()    //定义不需要认证就可以访问
	              .antMatchers("/oauth/*").permitAll()
	              .anyRequest().authenticated().accessDecisionManager(myAccessDecisionManager)
	              .and()
	          .formLogin()
	          	  .successHandler(myAuthenticationSuccessHandler)
	          	  .failureHandler(myAuthenticationFailureHandler)
	              .loginPage("/login")  //定义当需要用户登录时候，转到的登录页面
	              .permitAll()
	              .and()
	          .logout()
	              .permitAll();
	      http.csrf().disable();
	  }
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	      auth.authenticationProvider(myAuthenticationProvider);
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**/*.html");
	}
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
}
