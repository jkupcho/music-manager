package com.mke.meetup.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.mke.meetup.domain.Authority;
import com.mke.meetup.domain.SiteUser;
import com.mke.meetup.repo.AuthorityRepository;
import com.mke.meetup.repo.SiteUserRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final SiteUserRepository siteUserRepository;
	private final AuthorityRepository authorityRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public DatabaseLoader(SiteUserRepository siteUserRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
		this.siteUserRepository = siteUserRepository;
		this.authorityRepository = authorityRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		Authority userAuthority = new Authority("ROLE_USER");
		Authority adminAuthority = new Authority("ROLE_ADMIN");
		
		authorityRepository.save(userAuthority);
		authorityRepository.save(adminAuthority);
		
		List<Authority> adminRoles = Arrays.asList(userAuthority, adminAuthority);
		List<Authority> userRoles = Arrays.asList(userAuthority);
		
		SiteUser user = new SiteUser();
		user.setUsername("user");
		user.setPassword(passwordEncoder.encode("user"));
		user.getAuthorities().addAll(userRoles);
		
		SiteUser admin = new SiteUser();
		admin.setUsername("admin");
		admin.setPassword(passwordEncoder.encode("admin"));
		user.getAuthorities().addAll(adminRoles);
		
		siteUserRepository.save(user);
		siteUserRepository.save(admin);
	}

}
