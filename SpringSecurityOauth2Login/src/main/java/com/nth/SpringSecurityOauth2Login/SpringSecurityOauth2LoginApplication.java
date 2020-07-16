package com.nth.SpringSecurityOauth2Login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringSecurityOauth2LoginApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringSecurityOauth2LoginApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauth2LoginApplication.class, args);
	}

}
