package com.mke.meetup.repo.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mke.meetup.domain.Authority;
import com.mke.meetup.domain.SiteUser;
import com.mke.meetup.repo.AuthorityRepository;

@RepositoryEventHandler(SiteUser.class)
public class SiteUserEventHandler {

	private final PasswordEncoder passwordEncoder;
	private final AuthorityRepository authorityRepository;

	@Autowired
	public SiteUserEventHandler(PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository) {
		this.passwordEncoder = passwordEncoder;
		this.authorityRepository = authorityRepository;
	}
	
	@HandleBeforeCreate
	public void setDefaults(SiteUser user) {
		Authority userAuth = authorityRepository.findOne(AuthorityRepository.USER);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.getAuthorities().add(userAuth);
	}
	
}
