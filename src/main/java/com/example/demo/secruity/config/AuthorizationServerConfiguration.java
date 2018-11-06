package com.example.demo.secruity.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	RedisConnectionFactory redisConnectionFactory;
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
	AccessDeniedHandler myAccessDeniedHandler;
	
	@Autowired
	AuthenticationEntryPoint  myAuthenticationEntryPoint;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		   //允许表单认证
		security
        .realm("oauth2-resources") //code授权添加
        .tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()") //allow check token
        //.accessDeniedHandler(myAccessDeniedHandler)
        .authenticationEntryPoint(myAuthenticationEntryPoint)
        .allowFormAuthenticationForClients();

	}

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
        .tokenStore(new RedisTokenStore(redisConnectionFactory))
        //允许 GET、POST 请求获取 token，即访问端点：oauth/token
        .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("demoApp")
                .secret("demoAppSecret")
                .redirectUris("http://baidu.com")//code授权添加
                .authorizedGrantTypes("authorization_code","client_credentials", "password", "refresh_token")
                .scopes("all")
                .resourceIds("oauth2-resource")
                .accessTokenValiditySeconds(1200)
                .refreshTokenValiditySeconds(50000);
        		
    }
}
