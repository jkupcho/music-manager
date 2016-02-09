package com.mke.meetup.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class MusicManagerUser {

	@Id
	private String email;
	
	private String password;
	
	@ManyToMany
	@JoinTable(
		name="user_authorities_xref",
		joinColumns={@JoinColumn(name="username", referencedColumnName="username")},
		inverseJoinColumns={@JoinColumn(name="authority", referencedColumnName="authority")}
	)
	private Set<Authority> authorities = new HashSet<>();
	
	public UserDetails toUserDetails() {
		Set<GrantedAuthority> secAuthorities = authorities
			.stream()
			.map(Authority::toGrantedAuthority)
			.collect(Collectors.toSet());
		
		return new User(email, password, secAuthorities);
	}
	
}
