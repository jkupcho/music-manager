package com.mke.meetup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mke.meetup.repo.support.SiteUserEventHandler;

@Configuration
public class RestConfig {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public SiteUserEventHandler siteUserEventHandler() {
		return new SiteUserEventHandler(passwordEncoder);
	}
	
}
