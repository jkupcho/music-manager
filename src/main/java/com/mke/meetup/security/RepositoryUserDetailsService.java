package com.mke.meetup.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mke.meetup.domain.SiteUser;
import com.mke.meetup.repo.SiteUserRepository;

public class RepositoryUserDetailsService implements UserDetailsService {

	@Autowired
	private SiteUserRepository siteUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SiteUser user = siteUserRepository.findOneByUsername(username);
		
		if (user == null) { throw new UsernameNotFoundException("Username: " + username + " was not found."); }
		
		return user.toUserDetails();
	}

}
