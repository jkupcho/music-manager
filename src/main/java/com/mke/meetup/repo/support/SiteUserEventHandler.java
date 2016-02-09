package com.mke.meetup.repo.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mke.meetup.domain.SiteUser;

@RepositoryEventHandler(SiteUser.class)
public class SiteUserEventHandler {

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public SiteUserEventHandler(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@HandleBeforeCreate
	public void hashPassword(SiteUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	}
	
}
