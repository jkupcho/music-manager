package com.mke.meetup.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mke.meetup.domain.MusicManagerUser;
import com.mke.meetup.repo.MusicManagerUserRepository;

public class RepositoryUserDetailsService implements UserDetailsService {

	@Autowired
	private MusicManagerUserRepository musicManagerUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MusicManagerUser user = musicManagerUserRepository.findOne(username);
		
		if (user == null) { throw new UsernameNotFoundException("Username: " + username + " was not found."); }
		
		return user.toUserDetails();
	}

}
