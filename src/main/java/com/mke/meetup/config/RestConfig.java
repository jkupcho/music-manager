package com.mke.meetup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mke.meetup.domain.Authority;
import com.mke.meetup.repo.AuthorityRepository;
import com.mke.meetup.repo.support.SiteUserEventHandler;
import com.mke.meetup.security.UserDetailsAuditorAware;

@Configuration
@EnableJpaAuditing
public class RestConfig extends RepositoryRestMvcConfiguration {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		// Authority contains a single value which is the key, expose it rather than having to 
		// look it up.
		config.exposeIdsFor(Authority.class);
		config.setBasePath("/api");
	}
	
	@Bean
	public SiteUserEventHandler siteUserEventHandler() {
		return new SiteUserEventHandler(passwordEncoder, authorityRepository);
	}
	
	@Bean
	public AuditorAware<String> auditorProvider() {
		return new UserDetailsAuditorAware();
	}
	
}
