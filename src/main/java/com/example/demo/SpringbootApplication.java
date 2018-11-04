package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.Banner;
@SpringBootApplication
@MapperScan("com.example.demo.**.mapper")
public class SpringbootApplication {
	
	public static void main(String[] args) {
System.out.println("[课堂学情系统]-[微信管理服务] 开始启动...");
        
        SpringApplication app = new SpringApplication(SpringbootApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        System.out.println("[课堂学情系统]-[微信管理服务] 启动完成...");
	}
}
